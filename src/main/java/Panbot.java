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
		while (true) {
			turnRight(10);
			ahead(30);
			turnGunRight(360);
			back(20);
			turnGunRight(360);
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
		fire(2);
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan();
	}

	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		if (e.getEnergy() > 60) {
			fire(3);
		} else if (e.getEnergy() > 30) {
			fire(2);
		} else
			fire(1);
		ahead(40);
	}

	public void onBulletMissed(BulletMissedEvent event) {
		scan();
		out.println("Drat, I missed.");
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		fire(2);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		back(10);
	}	
}
