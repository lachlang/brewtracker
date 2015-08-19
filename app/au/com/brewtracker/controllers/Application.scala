package au.com.brewtracker.controllers

import play.api.Play
import au.com.brewtracker.dao.Brewers
import play.api.mvc._
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile


class Application extends Controller {

  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

//  val Brewers: Option
  def getBrewers = Action {request =>
//    def users = TableQuery[Brewers]
//    val db = Database.forConfig("slick.dbs.default.db")
//
//    try {
//      Await.result(db.run(users.result), Duration.Inf)
//    } finally db.close

    Ok("done this thing: " + Brewers.findByName("pants"))
  }

  def initBrewers = Action {request =>
//    val users = TableQuery[Brewers]
//
//    val db = Database.forConfig("slick.dbs.default.db")
//    try {
//      println("start run the db command")
//      Await.result(
//        db.run(DBIO.seq(
//
////      val setupAction: DBIO[Unit] = DBIO.seq(
//        // create the schema
//        users.schema.create,
//
//        // insert two User instances
//        users += (1L, "John","Doe"),
//        users += (2L, "Fred", "Smith")
//
//      )
////          .map { insertResult =>
////        insertResult foreach { numRows =>
////        println(s"Inserted $numRows into database table.")
////        }}
//
//      ), Duration .Inf)
//      println("finish run the db command")
//    } finally db.close
    Ok("done that thing\n")
  }
}
