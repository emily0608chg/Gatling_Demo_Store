package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{AddProduct, ContactScenario, VisitScenario}


class TotalSimulation extends BaseSimulation {

  setUp(
    VisitScenario().populationBuilder,
    //ContactScenario().populationBuilder,
    AddProduct().populationBuilder
  )

}
