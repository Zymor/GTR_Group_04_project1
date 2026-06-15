import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class controller {

    @FXML
    private Label labelTotal;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    void submit_button(ActionEvent event) {

    }
    VBox vbox = new VBox();

    HBox hbox = new HBox();
    HBox hbox_1 = new HBox();
    HBox hbox_2 = new HBox();

    Label label1 = new Label("Item 1");
    Label label2 = new Label("$1");
    Label label3 = new Label("Quantity:");
    ImageView imageView1 = new ImageView(new Image("file:image1.jpg"));
    Spinner<Integer> spinner_item1 = new Spinner<>(0, 10, 0);

    @FXML
    void initialize() {
        imageView1.setFitWidth(80);
        imageView1.setFitHeight(80);
        imageView1.setPreserveRatio(true);

        // add image and labels to row
        hbox.getChildren().addAll(imageView1, label1, label2, label3, spinner_item1);
        // add hbox into vbox 
        vbox.getChildren().addAll(hbox);

        // add vbox into scrollpane
        scrollpane.setContent(vbox);
    }
}