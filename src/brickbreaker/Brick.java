package brickbreaker;

import java.util.ArrayList;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Brick {
	Rectangle left;
	Rectangle right;
	Rectangle up;
	Rectangle down;
	ArrayList<Rectangle> sides;

	public Brick(Rectangle left, Rectangle right, Rectangle up, Rectangle down) {
		this.left  = left;
		this.right = right;
		this.up    = up;
		this.down  = down;
		sides      = new ArrayList<Rectangle>();

		sides.add(left);
		sides.add(right);
		sides.add(up);
		sides.add(down);

	}

	public boolean getCollision(Duple ddXddY, Ball ball) {
		for (Rectangle r : sides) {
			if (checkCollision(r, ball.getCircle()) ) {
				bounceBall(r, ddXddY);
				setInvis();
				return true;
			}
		}
		return false;
	}

	private boolean checkCollision(Rectangle side, Circle ball) {
		return side.getBoundsInParent().intersects(ball.getBoundsInParent());
	}

	private void bounceBall(Rectangle side, Duple ddXddY) {
		if (side == left || side == right) {
			ddXddY.set(-1.2, 1);
		} else if (side == up || side == down) {
			ddXddY.set(1, -1.2);
		}
	}

	private void setInvis() {
		for (Rectangle r : sides) {
			r.setVisible(false);
		}
	}

}
