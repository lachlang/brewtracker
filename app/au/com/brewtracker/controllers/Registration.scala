package au.com.brewtracker.controllers

import play.api.mvc._
/**
 * Created by lachlang on 31/07/2015.
 */
class Registration extends Controller {

  def register = Action{request => Ok("registered")}
}
