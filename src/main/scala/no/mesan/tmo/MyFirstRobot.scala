package no.mesan.tmo

import robocode.{ScannedRobotEvent, Robot}

class MyFirstRobot extends Robot {
  override def run() {
    while (true) {
      ahead(100)
      turnGunRight(360)
      back(100)
      turnGunRight(360)
    }
  }

  override def onScannedRobot(event: ScannedRobotEvent) {
     fire(1)
  }
}