package au.com.brewtracker.dao

import au.com.brewtracker.models.Brewer
import au.com.brewtracker.models.PlainTextCredentials

import play.api.Play
import scala.concurrent.Future
//import play.api.db.slick.HasDatabaseConfig
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.PostgresDriver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}
import slick.driver.JdbcProfile
//import org.joda.time.DateTime

/**
 * Created by Lachlan on 11/08/2015.
 */

//trait BrewersTable {

  class Brewers(tag: Tag) extends Table[Brewer](tag, "brewers") {
    //  extends Table[(Long, String, String, DateTime)](tag, "brewers") {

    def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def firstName: Rep[String] = column[String]("first_name")

    def lastName: Rep[String] = column[String]("last_name")

//    def credentialId: Rep[Long] = column[Long]("cred_id")

    def email: Rep[String] = column[String]("email")

    def hash: Rep[String] = column[String]("hash")

    // optional column so we can post a happy birthday message on login
    //  def dob: Rep[DateTime] = column[DateTime]("dob")

    // LG: 12-Aug-2015 We may want something like this at some point, if we want implement
    // a LHBS finder, but not today...
    //  def address: Rep[String] = column[String]("address_id")

//    def * : ProvenShape[Brewer] = (firstName, lastName, id)
    def * = (id.?, firstName, lastName, (email, hash)).shaped <> (
      { case (id, firstName, lastName, (email, hash)) =>
        Brewer(id, firstName, lastName, PlainTextCredentials.apply(email, hash))
//        (Brewer.apply _).tupled
      },
      { b: Brewer =>
        def f1(p: PlainTextCredentials) = PlainTextCredentials.unapply(p).get
        Some((b.id, b.firstName, b.lastName, f1(b.credentials)))
      })

    //  def * : ProvenShape[(Long, String, String, DateTime)] = (id, firstName, lastName, dob)
  }
//}

//class BrewersDao extends BrewersTable with HasDatabaseConfig[JdbcProfile] {
object Brewers {
  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val brewerQuery = TableQuery[Brewers]

  def findByName(name: String): Future[Seq[Brewer]] =
    dbConfig.db.run(brewerQuery.filter(_.firstName === name).result)

  def add(brewer: Brewer) =
    dbConfig.db.run(brewerQuery.insertOrUpdate(brewer))

  def findAll: Future[Seq[Brewer]] =
    dbConfig.db.run(brewerQuery.result)


  //  def registerBrewer(brewer: Brewer): Future[Brewer] =
//    dbConfig.db.run(brewerQuery.insertOrUpdate(brewer))
  // other queries go here
}

class Recipes(tag: Tag)
  extends Table[(Long, Option[String], Option[String], Long, Option[String], String)](tag, "recipes") {

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def batchName: Rep[Option[String]] = column[Option[String]]("batch_name")
  def style: Rep[Option[String]] = column[Option[String]]("style")
  def brewerId: Rep[Long] = column[Long]("brewer_id")
  def secondaryBrewers: Rep[Option[String]] = column[Option[String]]("additional_brewers")
  def dateBrewed: Rep[String] = column[String]("brew_date")
 // def hopAdditions: Rep[List[HopAdditions]] =

  def * : ProvenShape[(Long,Option[String], Option[String], Long, Option[String], String)] =
    (id, batchName, style, brewerId, secondaryBrewers, dateBrewed)

  // A reified foreign key relation that can be navigated to create a join
  def brewer: ForeignKeyQuery[Brewers, Brewer] =
    foreignKey("brewer_fk", brewerId, TableQuery[Brewers])(_.id)
}


class HopAdditions(tag: Tag)
  extends Table[(Long, String, Int, Float, Int, Option[String])](tag, "hop_additions") {

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  // free text but pre-populated in front end with defaults
  def name: Rep[String] = column[String]("name")
  def grams: Rep[Int] = column[Int]("grams")
  def alphaAcid: Rep[Float] = column[Float]("aa")
  def minutes: Rep[Int] = column[Int]("minutes")
  def comments: Rep[Option[String]] = column[Option[String]]("comments")

  def * : ProvenShape[(Long, String, Int, Float, Int, Option[String])] =
    (id, name, grams, alphaAcid, minutes, comments)
}

sealed trait MassUnit
case object Grams extends MassUnit
case object Kilos extends MassUnit

//trait MaltAddition(tag: Tag) extends Table(Long, Float, MassUnits) {
//  def id: Long = column[Long]("id", O.PrimaryKey, O.AutoInc)
//  def wieght: Float = column[Float]("wieght")
//  def units: MassUnit: column[MassUnit]("unit")
//}
//
//class GrainAdditions extends MaltAddition