package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass()
                    .getResource("/application/Cal_Scene.fxml"));
			primaryStage.setResizable(false);
			primaryStage.setTitle("Calculator 4.2");
			primaryStage.getIcons().add(new Image("file:../../image/icon.jpg"));
			Scene se = new Scene(root);
			se.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(se);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
