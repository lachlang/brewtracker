package au.com.brewtracker.models

import play.api.libs.json.__
import play.api.libs.json.Format
import play.api.libs.json.JsPath
import play.api.libs.json.Reads
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

/**
 * Created by lachlang on 19/08/2015.
 */
case class Brewer(id: Option[Long], firstName: String, lastName: String, credentials: PlainTextCredentials)

//object Brewer {
//
//  // In this format, an undefined friends property is mapped to an empty list
//  implicit val format: Format[Brewer] = (
//      (__ \ "id").formatNullable[Long] and
//      (__ \ "firstName").format[String] and
//      (__ \ "lastName").format[String]
//    )(Brewer.apply, unlift(Brewer.unapply))
//
//  implicit val brewerReads: Reads[Brewer] = (
//    (JsPath \ "id").readNullable[Long] and
//    (JsPath \ "firstName").read[String](minLength[String](1)) and
//    (JsPath \ "lastName").read[String](minLength[String](1))
//  )(Brewer.apply _)
//
//}

case class PlainTextCredentials(email: String, hash: String)

object PlainTextCredentials {

  implicit val format: Format[PlainTextCredentials] = (
      (__ \ "email").format[String] and
      (__ \ "password").format[String]
    )(PlainTextCredentials.apply, unlift(PlainTextCredentials.unapply))

  implicit val credentialReads: Reads[PlainTextCredentials] = (
      (JsPath \ "email").read[String] and
      (JsPath \ "password").read[String]
    ) (PlainTextCredentials.apply _)
}

case class HashedCredentials(id: Option[Long], email: String, hash: String)

object HashedCredentials {

  implicit val format: Format[HashedCredentials] = (
      (__ \ "id").formatNullable[Long] and
      (__ \ "email").format[String] and
      (__ \ "hash").format[String]
    )(HashedCredentials.apply, unlift(HashedCredentials.unapply))

  implicit val credentialReads: Reads[HashedCredentials] = (
      (JsPath \ "id").readNullable[Long] and
      (JsPath \ "email").read[String] and
      (JsPath \ "hash").read[String]
    ) (HashedCredentials.apply _)
}

case class Recipe(id: Long)

case class HopAddition(id: Long, name: String, grams: Int, alphaAcid: Float, minutes: Int, comments: String)
