package application;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FallingHollowRectangle extends FallingRectangle {

	public FallingHollowRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		//set the rectange become hollow
		shape.setFill(Color.WHITE);
		shape.setStroke(Color.BLACK);
		
		//make it slower
		((PathTransition)tran).setDuration(Duration.millis(20000));
		
	}


}
