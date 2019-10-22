package application;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.event.EventTarget;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.PolygonBuilder;
import javafx.util.Duration;

public class FallingTriangle extends FallingObject implements Rotatable{
	public FallingTriangle(double x, double y, double h){
		super((int)x, (int)y, new Polygon(), new PathTransition());

		((Polygon)shape).getPoints().addAll(new Double[] {x, y,
		        x - (Math.tan(0.5236)* h), y + h,
		        x + (Math.tan(0.5236)* h), y + h });
		setupAnimation();
		setupPath();
		this.getChildren().add(shape);
	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
	    tran.play();			
	}
	@Override
	public void setupAnimation(){
		((PathTransition)tran).setDuration(Duration.millis(10000));
		((PathTransition)tran).setNode(this);
		((PathTransition)tran).setPath(p);
		((PathTransition)tran).setCycleCount(1);
	}
	@Override
	public void rotate() {
		// TODO Auto-generated method stub
	     RotateTransition rt = new RotateTransition(Duration.millis(3000), this);
	     rt.setByAngle(180);
	     rt.setCycleCount(4);
	     rt.setAutoReverse(true);
	     rt.play();
	}

	@Override
	public void setupPath() {
		// TODO Auto-generated method stub
		p.getElements().add(new MoveTo(x, y));
		p.getElements().add( new LineTo(x , y + 50));
		p.getElements().add(new LineTo(x + 50, y + 50));
		p.getElements().add(new LineTo (x + 50 , y + 100));
		p.getElements().add(new LineTo(x, y + 100));
		p.getElements().add(new LineTo(x, y + 150));
	}
}
