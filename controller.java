import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class controller {

    @FXML
    private Label labelTotal;

    @FXML
    private ScrollPane scrollpane;

    // 2D array of items: {name, price, imageFile}
    private final Object[][] items = new Object[][] {
            {"Durain", 1, "image1.jpg"},
            {"Jackfruit", 2, "image2.jpg"},
            {"Longan", 3, "image3.jpg"}
    };

    private VBox vbox;
    private final List<Spinner<Integer>> spinners = new ArrayList<>();

    @FXML
    void submit_button(ActionEvent event) {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            int price = (Integer) items[i][1];
            int qty = spinners.get(i).getValue();
            total += price * qty;
        }
        labelTotal.setText("Total: $" + total);
    }

    @FXML
    void initialize() {
        vbox = new VBox(10);
        vbox.setSpacing(10);

        // no ListView: rows are shown directly in the scroll pane

        for (int i = 0; i < items.length; i++) {
            String name = (String) items[i][0];
            Integer price = (Integer) items[i][1];
            String imageFile = (String) items[i][2];

            ImageView iv = new ImageView();
            iv.setFitWidth(120);
            iv.setFitHeight(120);
            iv.setPreserveRatio(true);
            loadImage(iv, imageFile);

            Label nameLabel = new Label((i + 1) + ". " + name);
            Label priceLabel = new Label("$" + price);
            Label qtyLabel = new Label("Quantity:");

            Spinner<Integer> spinner = new Spinner<>(0, 10, 0);
            spinners.add(spinner);

            HBox row = new HBox(10);
            row.setSpacing(10);
            row.getChildren().addAll(iv, nameLabel, priceLabel, qtyLabel, spinner);

            vbox.getChildren().add(row);
        }

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
