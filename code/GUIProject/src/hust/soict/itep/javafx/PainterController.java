package hust.soict.itep.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {
    @FXML private Pane drawingAreaPane;
    @FXML public void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }
    @FXML private ToggleGroup myToggleGroup;
    @FXML public void drawingAreaMouseDragged(MouseEvent event){
        // Check if the eraser is selected
        if ("Eraser".equals(((RadioButton)myToggleGroup.getSelectedToggle()).getText())) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
        else {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}