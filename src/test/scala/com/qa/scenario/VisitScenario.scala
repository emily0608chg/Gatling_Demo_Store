package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.HomePage.initSession
import com.qa.models.{AboutUs, Category, Checkout, Customer, FatherClass, HomePage, Product}
import io.gatling.core.Predef._

case class VisitScenario() extends BaseSimulation {

  val scn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(AboutUs.getAboutUs).exitHereIfFailed
      .exec(Category.getCategory).exitHereIfFailed
      .exec(Product.view).exitHereIfFailed
      .exec(Product.add).exitHereIfFailed
      .exec(Customer.getLogin).exitHereIfFailed
      .exec(Customer.login).exitHereIfFailed
      .exec(Checkout.viewCart).exitHereIfFailed
      .exec(Checkout.completeCheckout).exitHereIfFailed


  val populationBuilder = setInjectionProfile(scn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)

}
