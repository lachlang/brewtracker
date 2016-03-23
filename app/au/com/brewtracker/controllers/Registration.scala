package au.com.brewtracker.controllers

import au.com.brewtracker.dao.Brewers
import au.com.brewtracker.models.Brewer
import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

/**
 * Created by lachlang on 31/07/2015.
 */
class Registration extends Controller {

  def register = Action.async(parse.json(maxLength = 2000)) { request =>
//    val body: Option[Brewer] = request.body.validate[Brewer].asOpt
//    body match {
    request.body.validate[Brewer].asOpt match {
      case Some(brewer) => Brewers.register(brewer).map(result => Created(Json.toJson(result)))
      case None => Future(BadRequest)
    }
  }
}