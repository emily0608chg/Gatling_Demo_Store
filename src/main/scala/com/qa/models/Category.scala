package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._


object Category extends FatherClass {

  def getCategory =
    feed(categoryFeeder)
      .exec(http("Load Category Page - #{categoryName}")
        .get("/category/#{categorySlug}")
        .check(status.is(200)))

}
