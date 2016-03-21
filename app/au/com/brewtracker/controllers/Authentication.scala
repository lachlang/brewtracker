package au.com.brewtracker.controllers

/**
 * Created by lachlang on 29/07/2015.
 */

import play.api._
import play.api.mvc._

class Authentication extends Controller {

  def login =
    Action{request =>
      //(username: String, password: String)
//      Ok("logged in")
      NotImplemented
  }

  def logout = Action{ NotImplemented }
}
