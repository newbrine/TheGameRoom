package game;

public class Duple {

	double dxMultiplier;
	double dyMultiplier;

	public Duple(double dx, double dy) {
		dxMultiplier = dx;
		dyMultiplier = dy;
	}

	public double getDX() {
		return dxMultiplier;
	}

	public double getDY() {
		return dyMultiplier;
	}

	public void set(double x, double y) {
		dxMultiplier = x;
		dyMultiplier = y;
	}
}
