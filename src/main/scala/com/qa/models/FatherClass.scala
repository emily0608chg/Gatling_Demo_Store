package com.qa.models

import com.qa.models.HomePage.{randomString, rnd}
import com.qa.utils.ConfigUtils
import io.gatling.core.Predef._
import io.gatling.http.Predef.{Cookie, addCookie, flushCookieJar}

class FatherClass extends ConfigUtils {

  val categoryFeeder = csv("data/categoryDetails.csv").random
  val jsonFeederProducts = jsonFile("data/productDetails.json").random
  val csvFeederLoginDetails = csv("data/loginDetails.csv").circular
  val contactUsDetails = csv("data/contactUsDetails.csv").circular



  def printAllAttribute(attribute: String) =
    exec(session => {
      val value =
        if (session.attributes.contains(attribute))
          if (session(attribute).isInstanceOf[Iterable[_]])
            session(attribute).as[Seq[Any]].mkString
          else
            session(attribute).as[String]
        else
          ""
      println(attribute + " -> " + value)
      session
    })
}
