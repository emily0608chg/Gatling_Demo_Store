package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Customer extends FatherClass {

  def getLogin = {
    exec(
      http("Load Login Page")
        .get("#{getLoginButton}")
        .check(status.is(200)))
  }

  def login = {
    feed(csvFeederLoginDetails)
      .exec(
        http("Customer Login Action")
          .post("#{getLoginButton}")
          .formParam("_csrf", "#{csrfValue}")
          .formParam("username", "#{username}")
          .formParam("password", "#{password}")
          .check(status.is(200))
          .check(css("#_csrf", "content").saveAs("csrfValue"))
      )
      .exec(session => {
        session.set("csrfValue", "#{csrfValue}")
        session.set("customerLoggedIn", true)
      })

  }
}
