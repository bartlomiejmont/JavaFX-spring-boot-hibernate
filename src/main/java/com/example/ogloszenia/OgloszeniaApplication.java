package com.example.ogloszenia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OgloszeniaApplication extends Application {

	public static ConfigurableApplicationContext springContext;
	private FXMLLoader fxmlLoader;


	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {

		springContext = SpringApplication.run(OgloszeniaApplication.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(springContext::getBean);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		fxmlLoader.setLocation(getClass().getResource("/loginView.fxml"));
		Parent rootNode = fxmlLoader.load();

		primaryStage.setTitle("Hello World");
		Scene scene = new Scene(rootNode, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.stop() ;
	}


}