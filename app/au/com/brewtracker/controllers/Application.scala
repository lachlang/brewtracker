package au.com.brewtracker.controllers

import au.com.brewtracker.database.Brewers
import play.api._
import play.api.mvc._
import slick.dbio.DBIO

import scala.concurrent.duration.Duration

//import slick.driver.H2Driver.api.TableQuery
//import slick.driver.H2Driver.api.Database
import slick.driver.H2Driver.api._

import scala.concurrent.Await

class Application extends Controller {

  def getBrewers = Action {request =>
    Ok("done this thing")
  }
  def initBrewers = Action {request =>
    val users = TableQuery[Brewers]

    val db = Database.forConfig("slick.dbs.default.db")
    try {
      Await.result(db.run(DBIO.seq(
        // create the schema
        users.schema.create,

        // insert two User instances
        users += (1L, "John","Doe"),
        users += (2L, "Fred", "Smith"),

        // print the users (select * from USERS)
        users.result
//      val rows = users.result
      )), Duration.Inf)
    } finally db.close
    Ok("done that thing\n")
  }
}
