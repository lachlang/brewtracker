package au.com.brewtracker.dao

import au.com.brewtracker.models.Brewer
import scala.concurrent.{Future, Await}
import scala.concurrent.duration.Duration
import slick.driver.PostgresDriver.api._

/**
 * Created by lachlang on 11/03/2016.
 */
object InitialLoad extends App {
  println("log this mofo")
  val db = Database.forConfig("default")

  try {
    val brewers: TableQuery[Brewers] = TableQuery[Brewers]

    println("log this too mofo")
    // the query interface for the Coffees table
    val recipes: TableQuery[Recipes] = TableQuery[Recipes]

    val setupAction: DBIO[Unit] = DBIO.seq(
      // Create the schema by combining the DDLs for the Suppliers and Coffees
      // tables using the query interfaces
      (brewers.schema ++ recipes.schema).create,

      // Insert some suppliers
      brewers += Brewer(101, "Dave", "Brewer"),
      brewers += Brewer( 49, "John", "Guy"),
      brewers += Brewer(150, "Matt", "Ale")
    )

    val setupFuture: Future[Unit] = db.run(setupAction)

    println("start to block")
    Await.result(setupFuture, Duration.Inf)

  } finally db.close
}
