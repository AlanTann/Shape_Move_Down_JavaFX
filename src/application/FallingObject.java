package application;


import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.scene.Group;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;


public abstract class FallingObject extends Group {
	public int x;
	public int y;
	Path p;
	Shape shape;
	Transition tran;
	public FallingObject(int x, int y, Shape s, Transition trans){
		this.x = x;
		this.y = y;
		this.p = new Path();
		this.shape = s;
		this.tran = trans;
	}
	public abstract void fall();
	public abstract void setupPath();
	public abstract void setupAnimation();
}
