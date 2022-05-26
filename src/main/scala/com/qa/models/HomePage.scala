package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random


object HomePage extends FatherClass {

  val rnd = new Random()

  def randomString(length: Int): String = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  val initSession = exec(flushCookieJar)
    .exec(session => session.set("randomNumber", rnd.nextInt))
    .exec(session => session.set("customerLoggedIn", false))
    .exec(session => session.set("cartTotal", 0.00))
    .exec(addCookie(Cookie("sessionId", randomString(10)).withDomain(BaseUrl)))

  def getHomePage = {
    exec(initSession)
      .exec(http("getHomePage")
        .get("/")
        .check(status.is(200))
        .check(css("#_csrf", "content").saveAs("csrfValue"))
        .check(css("a[href*='/about-us']", "href").saveAs("getAboutUsButton"))
        .check(css("a[href*='/login']", "href").saveAs("getLoginButton"))
        .check(css("a[href*='/contact']", "href").saveAs("getContactUsButton"))
      )

    .exec(printAllAttribute("getContactUsButton"))
  }

}






