package game;

import java.util.ArrayList;

public class Game {
	ArrayList<Brick> blocks;
	Ball   ball;
	Paddle paddle;
	Duple  ddXddY;

	int    score;

	public Game(ArrayList<Brick> blocks, Ball ball, Paddle paddle) {
		this.blocks = new ArrayList<Brick>();
		this.ball   = ball;
		this.paddle = paddle;
		this.score  = 0;
		this.ddXddY = new Duple(1, 1);

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

	public int getScore() {
		return score;
	}

	public boolean checkWin() {
		return blocks.isEmpty();
	}

	public boolean checkLoss() {
		return ball.getCircle().getCenterY() > 490;
	}

	public void handleCollisions() {
		handleBrickCollision();
		handlePaddleCollision();
	}

	private void handleBrickCollision() {
		for (Brick b : blocks) {
			if (b.getCollision(ddXddY, ball)) {
				score += 100;
				blocks.remove(b);

				updateBallVelocity();
			}
		}
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
		System.out.println(dx + " " + dy + " " + dfpc);
	}

	private void updateBallVelocity() {
		double dx = ball.getDX() * ddXddY.getDX();
		double dy = ball.getDY() * ddXddY.getDY();
		ball.setDX(dx);
		ball.setDY(dy);

		ddXddY.set(1, 1);
	}
}
