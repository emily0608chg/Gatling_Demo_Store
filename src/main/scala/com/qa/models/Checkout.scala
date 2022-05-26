package com.qa.models

import com.qa.utils.ConfigUtils
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Checkout extends FatherClass {

  def viewCart = {
    doIf(session => !session("customerLoggedIn").as[Boolean]) {
      exec(Customer.login)

    }
    exec(Customer.login)
      .exec(
        http("Load Cart Page")
          .get("#{getViewCartButton}")
          .formParam("_csrf", "#{csrfValue}")
          .check(status.is(200))
          .check(css("#grandTotal").saveAs("$$${cartTotal}"))
      )
      .exec(printAllAttribute("cartTotal"))
  }

  def completeCheckout = {
    exec(
      http("Checkout Cart")
        .get(finalCheckout)
        .check(status.is(200))
        .check(regex("""Thanks for your order! See you soon!"""))

    )
  }
}
