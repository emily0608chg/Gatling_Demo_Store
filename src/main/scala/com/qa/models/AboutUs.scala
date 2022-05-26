package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AboutUs extends FatherClass {

   def getAboutUs =
    exec(http("Load About Us Page")
      .get("#{getAboutUsButton}")
      .check(status.is(200)))



}
