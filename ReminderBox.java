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

public class ReminderBox
{
	public void display(String title, String szTitle, String szDesc)
	{
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		VBox layout = new VBox(30);
		layout.setStyle("-fx-background: #2233;");
		
		Label lTitle = new Label(szTitle);
		lTitle.setFont(new Font("Arial", 13));
		lTitle.setTextFill(Color.web("#000000"));
		
		Label lDesc = new Label(szDesc);
		lDesc.setFont(new Font("Arial", 13));
		lDesc.setTextFill(Color.web("#000000"));
		
		Button button = new Button("OK");
		button.setOnAction(e -> window.close());
		
		layout.getChildren().addAll(lTitle, lDesc, button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 280, 200);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	}
}
