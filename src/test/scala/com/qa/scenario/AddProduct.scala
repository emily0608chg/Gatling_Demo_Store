package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.HomePage.initSession
import com.qa.models.{Category, HomePage, Product}
import io.gatling.core.Predef.scenario

case class AddProduct () extends BaseSimulation {

  val scn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(Category.getCategory).exitHereIfFailed
      .exec(Product.view).exitHereIfFailed
      .exec(Product.add).exitHereIfFailed

  val populationBuilder = setInjectionProfile(scn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)


}
