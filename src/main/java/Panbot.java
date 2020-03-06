import robocode.*;

/**
 * Panbot - a robot by (your name here)
 */
public class Panbot extends Robot {
	/**
	 * run: Panbot's default behavior
	 */
	int turnDirection = 1;

	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while (true) {
			turnRight(10);
//			ahead(100);
//			turnGunRight(360);
//			back(20);
//			turnGunRight(360);
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {

		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan(); // Might want to move ahead again!
	}

	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		// Determine a shot that won't kill the robot...
		// We want to ram him instead for bonus points
		if (e.getEnergy() > 60) {
			fire(3);
		} else if (e.getEnergy() > 30) {
			fire(2);
		} else
			fire(1);
		ahead(40); // Ram him again!
	}


	public void onBulletHit(BulletHitBulletEvent event) {
		fire(2);
	}

	public void onBulletMissed(BulletMissedEvent event) {
		getGunHeading();
		out.println("Drat, I missed.");
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		fire(2);
//		if (event.getBearing()>= 0 && event.getBearing() < 90) {
//			back(10);
//		}
//		if (event.getBearing() >= 90 && event.getBearing() < 180) {
//			back(10);
//		}
//		if (event.getBearing() >= 180 && event.getBearing() < 270) {
//			ahead(10);
//		}
//		if (event.getBearing() >= 270 && event.getBearing() <= 360) {
//			ahead(10);
//		}
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
//		if (event.getBearing() >= 0 && event.getBearing() < 90) {
//			back(15);
//		}
//		if (event.getBearing() >= 90 && event.getBearing() < 180) {
//			back(15);
//		}
//		if (event.getBearing() >= 180 && event.getBearing() < 270) {
//			ahead(15);
//		}
//		if (event.getBearing() >= 270 && event.getBearing() <= 360) {
//			ahead(15);
//		}
	}	
}
