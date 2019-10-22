package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	double sceneX, sceneY;
	double transX, transY;
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			FallingObject objs[] = {
					new FallingRectangle(50,50, 30, 30),
					new FallingHollowRectangle(50, 150, 30, 30),
					new FallingCrossRectangle(50, 200, 30,30)
			};
			
			for (FallingObject o : objs){
				root.getChildren().add(o);

				o.addEventFilter(MouseEvent.MOUSE_PRESSED,
						new EventHandler<MouseEvent>(){

							@Override
							public void handle(MouseEvent t) {
								// TODO Auto-generated method stub
								sceneX = t.getSceneX();
								sceneY = t.getSceneY();
								transX = ((FallingObject)t.getSource()).getTranslateX();
								transY = ((FallingObject)t.getSource()).getTranslateY();
							}});
				o.addEventFilter(MouseEvent.MOUSE_DRAGGED, 
						new EventHandler<MouseEvent>(){

							@Override
							public void handle(MouseEvent event) {
								// TODO Auto-generated method stub
								double offsetX = event.getSceneX() - sceneX;
								double offsetY = event.getSceneY() - sceneY;
								double newTX = transX + offsetX;
								double newTY = transY + offsetY;
								
								((FallingObject)event.getSource()).setTranslateX(newTX);
								((FallingObject)event.getSource()).setTranslateY(newTY);
								
									
							}});
				o.fall();
			}
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
