package au.com.brewtracker.controllers

import au.com.brewtracker.dao.Brewers
import au.com.brewtracker.models.Brewer
import play.api.libs.json.Json
import play.api.mvc._
/**
 * Created by lachlang on 31/07/2015.
 */
class Registration extends Controller {

  def register = Action{request => Ok("registered")}

//  def register = Action.async(parse.json(maxLength = 2000)) { request =>
//    val brewer: Brewer = request.body.validate[Brewer].get
//    Brewers.add(brewer).map(result => Ok(Json.toJson(result)))
//  }
//
}
