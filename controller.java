import java.io.File;

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
    HBox hbox_2= new HBox();


    Label label1 = new Label("Item 1");
    Label label2 = new Label("$1");
    Label label3 = new Label("Quantity:");
    ImageView imageView1;
    Spinner<Integer> spinner_item1 = new Spinner<>(0, 10, 0);

    Label label1_item2 = new Label("Item 2");
    Label label2_item2 = new Label("$2");
    Label label3_item2 = new Label("Quantity:");
    ImageView imageView2;
    Spinner<Integer> spinner_item2 = new Spinner<>(0, 10, 0);

    Label label1_item3 = new Label("Item 3");
    Label label2_item3 = new Label("$3");
    Label label3_item3 = new Label("Quantity:");
    ImageView imageView3;
    Spinner<Integer> spinner_item3 = new Spinner<>(0, 10, 0);

    @FXML
    void initialize() {
        imageView1 = new ImageView();
        imageView1.setFitWidth(120);
        imageView1.setFitHeight(120);
        imageView1.setPreserveRatio(true);
        loadImage(imageView1, "image1.jpg");

        imageView2 = new ImageView();
        imageView2.setFitWidth(120);
        imageView2.setFitHeight(120);
        imageView2.setPreserveRatio(true);
        loadImage(imageView2, "image2.jpg");

        imageView3 = new ImageView();
        imageView3.setFitWidth(120);
        imageView3.setFitHeight(120);
        imageView3.setPreserveRatio(true);
        loadImage(imageView3, "image3.jpg");

        hbox.setSpacing(100);
        hbox_1.setSpacing(100);
        hbox_2.setSpacing(100);
        vbox.setSpacing(10);

        // add image and labels to row 1
        hbox.getChildren().addAll(imageView1, label1, label2, label3, spinner_item1);
        // add image and labels to row 2
        hbox_1.getChildren().addAll(imageView2, label1_item2, label2_item2, label3_item2, spinner_item2);
        // add image and labels to row 3
        hbox_2.getChildren().addAll(imageView3, label1_item3, label2_item3, label3_item3, spinner_item3);
        
        // add all hboxes into vbox 
        vbox.getChildren().addAll(hbox, hbox_1, hbox_2);

        // add vbox into scrollpane
        scrollpane.setContent(vbox);
    }

    private void loadImage(ImageView imageView, String imageName) {
        java.net.URL imageUrl = getClass().getResource("/" + imageName);
        if (imageUrl != null) {
            imageView.setImage(new Image(imageUrl.toExternalForm()));
        } else {
            imageView.setImage(new Image(new File(imageName).toURI().toString()));
        }
    }
}