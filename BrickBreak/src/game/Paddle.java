package game;

import javafx.scene.shape.Rectangle;

public class Paddle {
	Rectangle paddle;
	double xCor;
	double speed;

	public Paddle(Rectangle r) {
		paddle = r;
		xCor   = paddle.getLayoutX();
		speed  = 30;
	}

	public Rectangle getRect() {
		return paddle;
	}

	private void moveHelp(boolean add, double bounds) {
		int sign = add ? 1 : -1; //https://alvinalexander.com/java/edu/pj/pj010018

		if ((sign * xCor) + speed > (bounds * sign)) {
			xCor = bounds;
		} else {
			xCor += speed * sign;
		}
		//System.out.println("paddle moveHelp, add: " + add + " sign: " + sign + " bounds: " + bounds);
		draw();

	}

	public void moveLeft() {
		moveHelp(false, 0);
	}

	public void moveRight() {
		moveHelp(true, 400);
	}

	private void draw() {
		paddle.setLayoutX(xCor);
	}
}
