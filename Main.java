package eventReminder.pack;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application
{
	public static String version = "v1.0";
	
		// default day part
	public static String comboBoxDefaultValue = "AM";
	public int AP = 0;
	
	Label titleLabel, descLabel, dateLabel, hoursLabel, minutesLabel, secondsLabel, time;
	Button create, reset;
	TextField titleField, hoursField, minutesField, secondsField;
	TextArea descArea;
	ComboBox<String> combobox;
	AlertBox alertBox;
	
	public static Timer timer;
	public static Calendar calendar;
	
	public static int hours, minutes, seconds, realAP;
	public static String strTime;
	
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
			// ** initializing **
		
			// alert box
		alertBox = new AlertBox();
		
			// time
		calendar = Calendar.getInstance();
		
		hours = calendar.get(Calendar.HOUR);
		minutes =  calendar.get(Calendar.MINUTE);
		seconds = calendar.get(Calendar.SECOND);
		
		realAP = calendar.get(Calendar.AM_PM);
		
		if(hours == 0)
			hours = 12;
		
		strTime = (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds + 
				(calendar.get(Calendar.AM_PM) == 1 ? " PM" : " AM");
		
		time = new Label(strTime);
		
		time.setLayoutX(40);
		time.setLayoutY(20);
		
		time.setFont(new Font("Arial", 13));
		time.setTextFill(Color.web("#000000"));
		
		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask()
	    {
	        @Override
	        public void run()
	        {
	            Platform.runLater(() ->
	            {
	            	calendar = Calendar.getInstance();
					
					hours = calendar.get(Calendar.HOUR);
					minutes =  calendar.get(Calendar.MINUTE);
					seconds = calendar.get(Calendar.SECOND);
					
					realAP = calendar.get(Calendar.AM_PM);
					
					if(hours == 0)
						hours = 12;
					
					strTime = (hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds + 
							(calendar.get(Calendar.AM_PM) == 1 ? " PM" : " AM");
					time.setText(strTime);
					
					Control.check();
	            });
	        }
	    }, 1000, 1000);
		
			// title
		// label
		titleLabel = new Label("Title:");
		
		titleLabel.setLayoutX(290);
		titleLabel.setLayoutY(65);
		
		titleLabel.setFont(new Font("Arial", 17));
		titleLabel.setTextFill(Color.web("#000000"));
		
		// field
		titleField = new TextField();
		
		titleField.setLayoutX(235);
		titleField.setLayoutY(95);
		
			// description
		// label
		descLabel = new Label("Description:");
		
		descLabel.setLayoutX(130);
		descLabel.setLayoutY(170);
		
		descLabel.setFont(new Font("Arial", 17));
		descLabel.setTextFill(Color.web("#000000"));
		
		// area
		descArea = new TextArea();

		descArea.setPrefSize(200, 200);
		
		descArea.setLayoutX(75);
		descArea.setLayoutY(200);
		
			// date
		// label
		dateLabel = new Label("Date:");
		
		dateLabel.setLayoutX(425);
		dateLabel.setLayoutY(175);
		
		dateLabel.setFont(new Font("Arial", 17));
		dateLabel.setTextFill(Color.web("#000000"));
		
			// hours
		// label
		hoursLabel = new Label("H:");
		
		hoursLabel.setLayoutX(370);
		hoursLabel.setLayoutY(225);
		
		hoursLabel.setFont(new Font("Arial", 12));
		hoursLabel.setTextFill(Color.web("#000000"));
		
		// field
		hoursField = new TextField();
		
		hoursField.setLayoutX(390);
		hoursField.setLayoutY(220);
		
		hoursField.setPrefSize(30, 10);
		
		hoursField.textProperty().addListener(new textFieldChangeListener(hoursField));
		
			// minutes
		// label
		minutesLabel = new Label("M:");
		
		minutesLabel.setLayoutX(470);
		minutesLabel.setLayoutY(225);
		
		minutesLabel.setFont(new Font("Arial", 12));
		minutesLabel.setTextFill(Color.web("#000000"));
		
		// field
		minutesField = new TextField();
		
		minutesField.setLayoutX(490);
		minutesField.setLayoutY(220);
		
		minutesField.setPrefSize(30, 10);
		
		minutesField.textProperty().addListener(new textFieldChangeListener(minutesField));
		
			// seconds
		// label
		secondsLabel = new Label("S:");
		
		secondsLabel.setLayoutX(370);
		secondsLabel.setLayoutY(275);
		
		secondsLabel.setFont(new Font("Arial", 12));
		secondsLabel.setTextFill(Color.web("#000000"));
		
		// field
		secondsField = new TextField();
		
		secondsField.setLayoutX(390);
		secondsField.setLayoutY(270);
		
		secondsField.setPrefSize(30, 10);
		
		secondsField.textProperty().addListener(new textFieldChangeListener(secondsField));
		
			// combo box
		ObservableList<String> options = FXCollections.observableArrayList
		(
	        "AM",
	        "PM"
		);
		
		
		combobox = new ComboBox<String>(options);
		combobox.setValue(comboBoxDefaultValue);
		
		combobox.setLayoutX(455);
		combobox.setLayoutY(270);
		
		combobox.setPrefSize(65, 10);
		
		combobox.valueProperty().addListener(
				new ChangeListener<Object>()
				{
					@Override
					public void changed(ObservableValue<?> observable, Object oldValue, Object newValue)
					{
						if(combobox.getValue().equals("PM"))
							AP = 1;
						else
							AP = 0;
					}
				});
		
			// create
		create = new Button("Create");
		
		create.setLayoutX(495);
		create.setLayoutY(455);
		
		create.setPrefSize(65, 30);
		
		create.setOnAction((event) ->
		{
			if(titleField.getText().isEmpty() || descArea.getText().isEmpty() || hoursField.getText().isEmpty() || minutesField.getText().isEmpty() || secondsField.getText().isEmpty())
			{
				alertBox.display("ERROR", "Please fill all of the fields");
			}
			else
			{
					// get the time the user entered
				int hour = Integer.parseInt(hoursField.getText());
				int minute = Integer.parseInt(minutesField.getText());
				int second = Integer.parseInt(secondsField.getText());

				Control.addTask(new Task(titleField.getText(), descArea.getText(), hour, minute, second, AP));
				
					// reset the fields
				titleField.setText("");
				descArea.setText("");
				
				hoursField.setText("");
				minutesField.setText("");
				secondsField.setText("");
				
					// alert box
				alertBox.display("Successfully Creatred!", "Event successfuly created!");
			}
		});
		
			// reset
		reset = new Button("Reset");
		
		reset.setLayoutX(40);
		reset.setLayoutY(455);
		
		reset.setPrefSize(65, 30);
		
		reset.setOnAction(e ->
		{
			titleField.setText("");
			descArea.setText("");
			
			hoursField.setText("");
			minutesField.setText("");
			secondsField.setText("");
			
			combobox.setValue(comboBoxDefaultValue);
		});
		
			// ** layout **
		Pane layout = new Pane();
		layout.getChildren().addAll(titleLabel, titleField, descLabel, descArea, dateLabel, hoursLabel, hoursField, minutesLabel, minutesField,
				secondsLabel, secondsField, combobox, create, reset, time);
		
			// ** scene **
		Scene scene = new Scene(layout, 590, 500);
		
			// ** window **
		primaryStage.setOnCloseRequest((event) -> timer.cancel());
		primaryStage.setTitle("Event Reminder " + version);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
		// the class that taking care of the hours, minutes and seconds
	class textFieldChangeListener implements ChangeListener<String>
	{
		TextField textField;
		
		public textFieldChangeListener(TextField textField)
		{
			this.textField = textField;
		}
		
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
		{
			try
			{
				int num = Integer.parseInt(textField.getText());
				int max, min;
				
				if(this.textField == hoursField)
				{
					max = 12;
					min = 1;
				}
				else
				{
					max = 60;
					min = 0;
				}	
				
				if(num > max || num < min)
				{
					textField.setText("");
					alertBox.display("ERROR", "The number has to be between 1-" + (this.textField == hoursField ? "12" : "60"));
				}
			} catch(Exception e)
			{
				if(textField.getText().length() > 0)
					textField.setText(textField.getText().substring(0, textField.getText().length()-1));
			}
		}
	}
}
