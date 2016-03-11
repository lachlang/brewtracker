package au.com.brewtracker.dao

import au.com.brewtracker.models.Brewer
import slick.backend.DatabasePublisher
import slick.driver.H2Driver.api._

/**
 * Created by lachlang on 11/03/2016.
 */
object InitialLoad extends App {
  val db = Database.forConfig("h2mem1")

  try {
    val brewers: TableQuery[Brewers] = TableQuery[Brewers]

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

  } finally db.close
}
