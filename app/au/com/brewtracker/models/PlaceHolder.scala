package au.com.brewtracker.models

import play.api.libs.json.__
import play.api.libs.json.Format
//import play.api.libs.functional.syntax.unlift
//import play.api.libs.functional.syntax.and
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
}

case class Credential(id: Long, user: String, password: String, hash: String)

case class Recipe(id: Long)

case class HopAddition(id: Long, name: String, grams: Int, alphaAcid: Float, minutes: Int, comments: String)

