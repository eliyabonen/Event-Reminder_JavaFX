package eventReminder.pack;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
	public void display(String title, String message)
	{
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		VBox layout = new VBox(20);
		
		Label label = new Label(message);
		label.setFont(new Font("Arial", 13));
		label.setTextFill(Color.web("#000000"));
		layout.setStyle("-fx-background: #2233;");
		
		Button button = new Button("OK");
		button.setOnAction(e -> window.close());
		
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 280, 90);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	}
}
