package blackhole;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Blackhole {

	private double radius;
	private double change;
	private Circle c;

	public Blackhole(double change, double radius, Circle c) {
		this.change = change;
		this.radius = radius;
		this.c = c;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setColor(Color c) {
		this.c.setFill(c);
	}

	public double getRadius() {
		return radius;
	}
	

	public Circle getCircle() {
		return c;
	}

	public void shrink() {
		radius -= change;
		c.setRadius(radius);
	}

	public void enlarge() {
		radius += change * 1.5;
		c.setRadius(radius);
	}

}