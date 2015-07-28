package controllers

/**
 * Created by lachlang on 29/07/2015.
 */

import play.api._
import play.api.mvc._

class Brewer extends Controller{

  def recipeList(id: Long) = Action{request => Ok("Hello World :) \nbrewerId: '" + id + "'\n[" + request+ "]")}
}
