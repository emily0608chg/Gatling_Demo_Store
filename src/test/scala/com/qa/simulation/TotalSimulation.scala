package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.VisitScenario

class TotalSimulation extends BaseSimulation {

  setUp(
    VisitScenario().populationBuilder
  )
}
