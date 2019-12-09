package dad.javafx.geofx;

import dad.javafx.geofx.controller.GeofxController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeofxApp extends Application{

	private GeofxController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new GeofxController();

		Scene scene = new Scene(controller.getView());

		primaryStage.setTitle("GeoFX - Aitor del Castillo");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
