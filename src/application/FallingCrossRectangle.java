package application;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.util.Duration;

public class FallingCrossRectangle extends FallingHollowRectangle{

	public FallingCrossRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		PathElement cross[] = {
			new MoveTo(x, y),
			new LineTo(x + width, y + height),
			new MoveTo(x + width, y),
			new LineTo(x, y + height),
		};
		Path p = new Path();
		p.getElements().addAll(cross);
		getChildren().add(p);
		
		((PathTransition)tran).setDuration(Duration.millis(5000));
		
	}
	

}
