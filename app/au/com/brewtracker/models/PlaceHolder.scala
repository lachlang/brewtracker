package au.com.brewtracker.models

/**
 * Created by lachlang on 19/08/2015.
 */
case class Brewer(id: Long, firstName: String, lastName: String)

case class Credential(id: Long, user: String, password: String, hash: String)

case class Recipe(id: Long)

case class HopAddition(id: Long, name: String, grams: Int, alphaAcid: Float, minutes: Int, comments: String)