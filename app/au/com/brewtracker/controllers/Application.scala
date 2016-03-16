package au.com.brewtracker.controllers

import play.api.Play
import au.com.brewtracker.models.Brewer
import au.com.brewtracker.dao.{Recipes, Brewers}
import play.api.mvc._
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import slick.driver.PostgresDriver.api._

class Application extends Controller {

  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  // LG 2016-03-12 Wow, this stuff doesn't look right :(
  val matchedBrewers: Future[Seq[Brewer]] = Brewers.findByName("pants")
  def getBrewers = Action.async {request =>

    //TODO: use a format string FFS
    Brewers.findAll.map(result => Ok("Returned row count: " + result.size + "\n{brewers: {" + result.foreach{
      case Brewer(firstName,lastName, Some(id)) => "id:\"" + id + "\", firstName: \"" + firstName +  "\", lastName: \"" + lastName + "\"},\n"} + "}"))
//    Ok("done this thing: " + matchedBrewers )
  }

  def initBrewers = Action {request =>

    println("log this mofo")
    val db = Database.forConfig("slick.dbs.default.db")

    try {
      val brewers: TableQuery[Brewers] = TableQuery[Brewers]

      println("log this too mofo")
      // the query interface for the Coffees table
      val recipes: TableQuery[Recipes] = TableQuery[Recipes]

      val setupAction: DBIO[Unit] = DBIO.seq(
        // Insert some suppliers
        brewers += Brewer("Dave", "Brewer"),
        brewers += Brewer("John", "Guy"),
        brewers += Brewer("Matt", "Ale")
//        brewers += Brewer(101L, "Dave", "Brewer"),
//        brewers += Brewer( 49L, "John", "Guy"),
//        brewers += Brewer(150L, "Matt", "Ale")
      )

      val setupFuture: Future[Unit] = db.run(setupAction)

      println("start to block")
      Await.result(setupFuture, Duration.Inf)

    } finally db.close

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