package application;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.input.ZoomEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;


public class FallingCircle extends FallingObject{

	public FallingCircle(int x, int y, int rad) {
		super(x, y, new Circle(), new PathTransition());
		((Circle)shape).setCenterX(x);
		((Circle)shape).setCenterY(y);
		((Circle)shape).setRadius(rad);
		this.getChildren().add(shape);
		setupPath();
		setupAnimation();
	}
	@Override
	public void setupPath(){
		p.getElements().add(new MoveTo(x, y));
		p.getElements().add( new LineTo(x , y + 50));
		p.getElements().add(new LineTo(x - 50, y + 100));
		p.getElements().add(new LineTo (x , y + 150));
		p.getElements().add(new LineTo(x, y + 200));		
	}
	@Override
	public void setupAnimation(){
		((PathTransition)tran).setDuration(Duration.millis(10000));
		((PathTransition)tran).setNode(this);
		((PathTransition)tran).setPath(p);
		((PathTransition)tran).setCycleCount(1);
	}
	// TODO Auto-generated method stub
	@Override
	public void fall() {
	    tran.play();				
	}

}
