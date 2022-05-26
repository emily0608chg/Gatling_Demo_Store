package com.qa.models

import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef._

object ContactUs extends FatherClass {

  def getContactUs =
    exec(http("Load Contact Us Page")
      .get("#{getContactUsButton}")
      .check(status.is(200))
      .check(css("a[href='https://gatling.io/company/contact/']", "href").saveAs("getContactPage"))
    )

      .exec(printAllAttribute("getContactPage"))

  def getForm =
    exec(http("Load Form Contact")
      .get("#{getContactPage}")
      .check(status.is(200))
      .check(css("#job_title-36adf488-429e-45a3-820c-7accd04c98cc > option(1)", "Value").findAll.saveAs("JobTitle"))
    )

  def contactMessage = {
    feed(contactUsDetails)
      .exec(http("Send Message to Gatling")
        .post("//www.facebook.com/tr/")
        .formParam("Last name", "#{LastName}")
        .formParam("First name", "#{FirstName}")
        .formParam("Company name", "#{CompanyName}")
        .formParam("Job title", "#{JobTitle}")
        .formParam("Email", "#{Email}")
        .formParam("Message", "#{Message}")
        .check(status.is(200)))
  }
}
