package no.mesan.tmo

import java.awt.Color
import robocode._

class LalaBot extends Robot {
  var loc : (Double, Double) = (0, 0)
  var heading : Double = 0

  override def run() {
    setColors(Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN, Color.GREEN)
    turnGunLeft(30)

    while(true) {

      ahead(200 * java.lang.Math.random)
      turnLeft(20 * java.lang.Math.random)
      moveGun
    }
  }

  var dir : Direction = Higher
  def moveGun {
    dir.move
    dir = dir.switch
  }

  override def onStatus(e: StatusEvent) {
    val status = e.getStatus

    loc = (status.getX, status.getY)
    heading = status.getHeading
  }

  override def onHitWall(event: HitWallEvent) {
    turnLeft(event.getBearing)
  }

  override def onScannedRobot(event: ScannedRobotEvent) {
    event.getDistance match {
      case i if i < 100 =>
        fire(8)
      case _ =>
        fire(2)
    }
  }

  abstract class Direction {
    def switch : Direction
    def move : Unit
  }
  case object Higher extends Direction {
    def switch = Lower
    def move = {
      turnGunRight(60)
    }
  }
  case object Lower extends Direction {
    def switch = Higher
    def move = {
      turnGunLeft(60)
    }
  }
}
