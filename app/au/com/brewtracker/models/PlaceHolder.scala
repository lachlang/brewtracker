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
case class Brewer(firstName: String, lastName: String, id: Option[Long] = None)

object Brewer {

  // In this format, an undefined friends property is mapped to an empty list
  implicit val format: Format[Brewer] = (
      (__ \ "firstName").format[String] and
      (__ \ "lastName").format[String] and
      (__ \ "id").formatNullable[Long]
    )(Brewer.apply, unlift(Brewer.unapply))

  implicit val brewerReads: Reads[Brewer] = (
    (JsPath \ "firstName").read[String](minLength[String](1)) and
    (JsPath \ "lastName").read[String](minLength[String](1)) and
    (JsPath \ "id").readNullable[Long]
  )(Brewer.apply _)
}

case class Credential(id: Long, user: String, password: String, hash: String)

case class Recipe(id: Long)

case class HopAddition(id: Long, name: String, grams: Int, alphaAcid: Float, minutes: Int, comments: String)
