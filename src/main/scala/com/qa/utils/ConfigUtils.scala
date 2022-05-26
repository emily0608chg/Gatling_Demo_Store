package com.qa.utils

import com.typesafe.config.ConfigFactory

trait ConfigUtils {

  val config = ConfigFactory.load("performance")
  val BaseUrl= config.getString("BaseUrl")
  val durationMeasurements = config.getString("durationMeasurements")
  val simulationDuration = config.getInt("simulationDuration")
  val loadUsers = config.getInt("loadUsers")
  val L10n = ConfigFactory.load("L10n")
  val checkoutURL = L10n.getString("CheckoutURL")
  val finalCheckout = L10n.getString("FinalCheckout")



}
