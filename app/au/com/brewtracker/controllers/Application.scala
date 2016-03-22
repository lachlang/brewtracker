package au.com.brewtracker.controllers

import play.api.Play
import au.com.brewtracker.models.Brewer
import au.com.brewtracker.dao.{Recipes, Brewers}
import play.api.mvc.{Controller, Action}
import play.api.libs.json.Json
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import slick.driver.PostgresDriver.api._

/**
 * TODO: Remove this class
 * LG: 2016-03-21 This is a test class for prototyping
 */
class Application extends Controller {

//  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def getBrewers = Action.async {request =>

    Brewers.findAll.map(result => Ok(Json.toJson(result)))
  }

  def addBrewer = Action.async(parse.json(maxLength = 2000)) { request =>
    val brewer: Brewer = request.body.validate[Brewer].get
    Brewers.add(brewer).map(result => Ok(Json.toJson(result)))
  }

  def initBrewers = Action {request =>

    val db = Database.forConfig("slick.dbs.default.db")

    try {
      val brewers: TableQuery[Brewers] = TableQuery[Brewers]

      // the query interface for the Coffees table
      val recipes: TableQuery[Recipes] = TableQuery[Recipes]

      val setupAction: DBIO[Unit] = DBIO.seq(
        // Insert some suppliers
        brewers += Brewer(None, "Dave", "Brewer"),
        brewers += Brewer(None, "John", "Guy"),
        brewers += Brewer(None, "Matt", "Ale")
      )

      val setupFuture: Future[Unit] = db.run(setupAction)

      Await.result(setupFuture, Duration.Inf)

    } finally db.close

    Ok("done that thing\n")
  }
}