package au.com.brewtracker.controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def getBrewers = Action {request =>
    Ok("done this thing")
  }
  def initBrewers = Action {request =>
    Ok("done that thing")
  }
}
