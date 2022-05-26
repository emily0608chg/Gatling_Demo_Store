package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Product extends FatherClass {

  def view =
      feed(jsonFeederProducts)
        .exec(http("Load Product Page - #{name}")
          .get("/product/#{slug}")
          .check(status.is(200))
        )

  def add = {
    repeat(5){
      feed(jsonFeederProducts)
        .exec(http("Add Product to Cart")
          .get("/cart/add/#{id}")
          .check(status.is(200))
          .check(css("a[href*='/cart/view']", "href").saveAs("getViewCartButton"))
        )
        .exec(session => {
          val itemPrice = session("price").as[Double]
          session.set("cartTotal", + itemPrice)
        })
    }
        .exec(printAllAttribute("cartTotal"))


  }

}
