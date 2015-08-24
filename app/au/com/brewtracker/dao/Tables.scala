package au.com.brewtracker.dao

import au.com.brewtracker.models.Brewer

import play.api.Play
import scala.concurrent.Future
import play.api.db.slick.HasDatabaseConfig
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.H2Driver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}
import slick.driver.JdbcProfile
import org.joda.time.DateTime

/**
 * Created by Lachlan on 11/08/2015.
 */

//trait BrewersTable {

  class Brewers(tag: Tag) extends Table[Brewer](tag, "brewers") {
    //  extends Table[(Long, String, String, DateTime)](tag, "brewers") {

    def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def firstName: Rep[String] = column[String]("first_name")

    def lastName: Rep[String] = column[String]("last_name")

    // optional column so we can post a happy birthday message on login
    //  def dob: Rep[DateTime] = column[DateTime]("dob")

    // LG: 12-Aug-2015 We may want something like this at some point, if we want implement
    // a LHBS finder, but not today...
    //  def address: Rep[String] = column[String]("address_id")

//    def * : ProvenShape[(Long, String, String)] = (id, firstName, lastName)
    def * = (id, firstName, lastName) <> (Brewer.tupled, Brewer.unapply _)

    //  def * : ProvenShape[(Long, String, String, DateTime)] = (id, firstName, lastName, dob)
  }
//}

//class BrewersDao extends BrewersTable with HasDatabaseConfig[JdbcProfile] {
object Brewers {
  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val brewerQuery = TableQuery[Brewers]

  def findByName(name: String): Future[Seq[Brewer]] =
    dbConfig.db.run(brewerQuery.filter(_.firstName === name).result)

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
  extends Table[(Long, String, Int, Float, Int, String)](tag, "hop_additions") {

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  // free text but pre-populated in front end with defaults
  def name: Rep[String] = column[String]("name")
  def grams: Rep[Int] = column[Int]("grams")
  def alphaAcid: Rep[Float] = column[Float]("aa")
  def minutes: Rep[Int] = column[Int]("minutes")
  def comments: Rep[String] = column[String]("comments")

  def * : ProvenShape[(Long, String, Int, Float, Int, String)] =
    (id, name, grams, alphaAcid, minutes, comments)
}