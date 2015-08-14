package au.com.brewtracker.controllers

import au.com.brewtracker.database.Brewers
import play.api.mvc._
import slick.dbio.DBIO
import scala.concurrent.Await
import scala.concurrent.duration.Duration

//import slick.driver.H2Driver.api.TableQuery
//import slick.driver.H2Driver.api.Database
import slick.driver.H2Driver.api._


class Application extends Controller {

  def getBrewers = Action {request =>
    def users = TableQuery[Brewers]
    val db = Database.forConfig("slick.dbs.default.db")

    try {
      Await.result(db.run(users.result), Duration.Inf)
    } finally db.close

    Ok("done this thing: " + users.result)
  }

  def initBrewers = Action {request =>
    val users = TableQuery[Brewers]

    val db = Database.forConfig("slick.dbs.default.db")
    try {
      println("start run the db command")
      Await.result(
        db.run(DBIO.seq(

//      val setupAction: DBIO[Unit] = DBIO.seq(
        // create the schema
        users.schema.create,

        // insert two User instances
        users += (1L, "John","Doe"),
        users += (2L, "Fred", "Smith")

      )
//          .map { insertResult =>
//        insertResult foreach { numRows =>
//        println(s"Inserted $numRows into database table.")
//        }}

      ), Duration .Inf)
      println("finish run the db command")
    } finally db.close
    Ok("done that thing\n")
  }
}
