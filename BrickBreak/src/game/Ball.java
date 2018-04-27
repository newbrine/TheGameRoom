package game;

import javafx.scene.shape.Circle;

public class Ball {
	Circle ball;
	double dx;
	double dy;
	double xCor;
	double yCor;

	public Ball( Circle b) {
		ball = b;
		dx = 3;
		dy = 3;
		xCor = b.getLayoutX();
		yCor = b.getLayoutY();
	}

	public Circle getCircle() {
		return ball;
	}

	public double getDX() {
		return dx;
	}

	public double getDY() {
		return dy;
	}

	public void setDX(double newSpeed) {
		dx = newSpeed;
	}

	public void setDY(double newSpeed) {
		dy = newSpeed;
	}

	private double bounceOffOuterWalls(double cor, double d) {
		if (cor + d <= 5 || cor + d >= 495) {
			return d * -0.8;
		}
		return d;
	}

	public void draw() {
		dx = bounceOffOuterWalls(xCor, dx);
		dy = bounceOffOuterWalls(yCor, dy);
		xCor += dx;
		yCor += dy;
		ball.setLayoutX(xCor);
		ball.setLayoutY(yCor);
	}
}
