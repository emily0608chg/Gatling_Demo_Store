package com.qa.scenario
import com.qa.BaseSimulation
import com.qa.models.HomePage.initSession
import com.qa.models.{ContactUs, FatherClass, HomePage}
import io.gatling.core.Predef.scenario

case class ContactScenario() extends BaseSimulation {

  val scnContact =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(ContactUs.getContactUs).exitHereIfFailed
      .exec(ContactUs.contactMessage).exitHereIfFailed

  val populationBuilder = setInjectionProfile(scnContact, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)

}
