package au.com.brewtracker.database

import slick.driver.H2Driver.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by Lachlan on 11/08/2015.
 */
class Recipes(tag: Tag)
  extends Table[(Long, String, String, String, String, String)](tag, "RECIPES") {

  def id: Rep[Long] = column[Long]("SUP_ID", O.PrimaryKey)
  def batchName: Rep[String] = column[String]("SUP_NAME")
  def style: Rep[String] = column[String]("SUP_NAME")
  def brewer: Rep[String] = column[String]("SUP_NAME")
  def secondaryBrewers: Rep[String] = column[String]("SUP_NAME")
  def dateBrewed: Rep[String] = column[String]("SUP_NAME")
 // def hopAdditions: Rep[List[HopAdditions]] =

  def * : ProvenShape[(Long,String, String, String, String, String)] =
    (id, batchName, style, brewer, secondaryBrewers, dateBrewed)

//  // A reified foreign key relation that can be navigated to create a join
//  def brewer: ForeignKeyQuery[Suppliers, (Int, String, String, String, String, String)] =
//    foreignKey("SUP_FK", supID, TableQuery[Suppliers])(_.id)
}


class HopAdditions(tag: Tag)
  extends Table[(Long, String, Int, Float, Int, String)](tag, "HOP_ADDITIONS") {

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey)
  // free text but pre-populated in front end with defaults
  def name: Rep[String] = column[String]("name")
  def grams: Rep[Int] = column[Int]("grams")
  def alphaAcid: Rep[Float] = column[Float]("aa")
  def minutes: Rep[Int] = column[Int]("minutes")
  def comments: Rep[String] = column[String]("comments")

  def * : ProvenShape[(Long, String, Int, Float, Int, String)] =
    (id, name, grams, alphaAcid, minutes, comments)
}