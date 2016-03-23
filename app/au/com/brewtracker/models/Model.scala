package au.com.brewtracker.models

import play.api.libs.json.Format
import play.api.libs.json.Format._
import play.api.libs.json.JsPath
import play.api.libs.functional.syntax._

/**
 * Created by lachlang on 19/08/2015.
 */
case class Brewer(id: Option[Long], firstName: String, lastName: String, credentials: HashedCredentials)

object Brewer {

  implicit val format: Format[Brewer] = (
    (JsPath \ "data" \ "id").formatNullable[Long] and
    (JsPath \ "data" \ "firstName").format[String] and
    (JsPath \ "data" \ "lastName").format[String] and
    (JsPath \ "data" \ "creds").format[HashedCredentials]
  )(Brewer.apply, unlift(Brewer.unapply))
}

case class PlainTextCredentials(email: String, hash: String)

object PlainTextCredentials {

  implicit val format: Format[PlainTextCredentials] = (
      (JsPath \ "email").format[String] and
      (JsPath \ "password").format[String]
    )(PlainTextCredentials.apply, unlift(PlainTextCredentials.unapply))
}

case class HashedCredentials(email: String, hash: String)

object HashedCredentials {

  implicit val format: Format[HashedCredentials] = (
    (JsPath \ "email").format[String] and
    (JsPath \ "hash").format[String]
  )(HashedCredentials.apply, unlift(HashedCredentials.unapply))
}

case class Recipe(id: Long)

case class HopAddition(id: Long, name: String, grams: Int, alphaAcid: Float, minutes: Int, comments: String)
