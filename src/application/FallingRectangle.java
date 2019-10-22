package application;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.scene.Parent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FallingRectangle extends FallingObject implements Rotatable{

	public FallingRectangle(int x, int y, int width, int height) {
		 super(x, y, new Rectangle(), new PathTransition());
		// setup the property of shape
		((Rectangle)shape).setX(x);
		((Rectangle)shape).setY(y);
		((Rectangle)shape).setWidth(width);
		((Rectangle)shape).setHeight(height);
		
		//setup the path
		setupPath();
		//setup animation
		setupAnimation();
		this.getChildren().add(shape);
		
	}
	@Override
	public void setupPath(){
		p.getElements().add(new MoveTo(x, y));
		p.getElements().add( new LineTo(x + 50, y + 50));
		p.getElements().add(new LineTo(x , y + 100));
		p.getElements().add(new LineTo (x + 50 , y + 150));
		p.getElements().add(new LineTo(x, y + 200));
	}
	@Override 
	public void setupAnimation(){
		((PathTransition)tran).setDuration(Duration.millis(10000));
		((PathTransition)tran).setNode(this);
		((PathTransition)tran).setPath(p);
		((PathTransition)tran).setCycleCount(1);
	    		
	}
	@Override
	public void fall() {
		// TODO Auto-generated method stub
		tran.play();	
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

}
