package brickbreaker;

import java.util.ArrayList;

import javafx.application.Platform;

public class Game {
	ArrayList<Brick> blocks;
	ArrayList<Brick> toRemove;
	Ball   ball;
	Paddle paddle;
	Duple  ddXddY;

	static int score;
	int time;
	int countToSixty;

	public Game(ArrayList<Brick> blocks, Ball ball, Paddle paddle) {
		this.toRemove = new ArrayList<Brick>();
		this.blocks = new ArrayList<Brick>();
		this.ball   = ball;
		this.paddle = paddle;
		this.score  = 0;
		this.time   = 60;
		this.ddXddY = new Duple(1, 1);
		this.countToSixty = 0;

		copyBlocksList(blocks);
	}

	private void copyBlocksList(ArrayList<Brick> blocks) {
		for (Brick b : blocks) {
			this.blocks.add(b);
		}
	}

	public void increaseScore(int points) {
		score += points;
	}

	public static int getScore() {
		return score;
	}

	public int getTime() {
		return time;
	}

	public boolean checkWin() {
		if (blocks.isEmpty()) {
			score += time * 10;
			return true;
		}
		return false;
	}

	public boolean checkLoss() {
		return ball.getCircle().getLayoutY() > 470;
	}

	public void handleCollisions() {
		handleBrickCollision();
		handlePaddleCollision();
		removeBricks();
	}

	private void handleBrickCollision() {

		Platform.runLater(() -> {
			for (Brick b : blocks) {
				if (b.getCollision(ddXddY, ball)) {
					score += 100;
					toRemove.add(b);

					updateBallVelocity();
				}
			}
		});
	}

	private void removeBricks() {
		for (Brick b : toRemove) {
			blocks.remove(b);
		}
		toRemove.clear();
	}

	private void handlePaddleCollision() {
		if (ball.getCircle().getBoundsInParent().intersects(paddle.getRect().getBoundsInParent())) {
			double distanceFromPaddleCenter = ball.getCircle().getLayoutX() - paddle.getRect().getLayoutX() - 50;
			redistributeVelocity(distanceFromPaddleCenter);
			ddXddY.set(1, -1);

			updateBallVelocity();
		}
	}

	private void redistributeVelocity(double dfpc) {

		double totalVelocity = Math.abs(ball.getDX()) + Math.abs(ball.getDY());
		double dx = totalVelocity * (dfpc / 60);
		double dy = totalVelocity - Math.abs(dx);

		ball.setDX(dx);
		ball.setDY(dy);
	}

	private void updateBallVelocity() {
		double dx = ball.getDX() * ddXddY.getDX();
		double dy = ball.getDY() * ddXddY.getDY();
		ball.setDX(dx);
		ball.setDY(dy);

		ddXddY.set(1, 1);
	}

	public boolean countDown() {
		if (countToSixty < 60) {
				countToSixty += 1;
		} else {
			countToSixty = 0;
			time -= 1;
			if (time <= 0) {

				return false;
			}
		}
		return true;
	}
}
