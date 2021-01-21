package coureur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Coureur extends Application {

	Stage stage;
	private Label titleLabel;
	private Label statusLabel;
	private Button addGirlfriendButton;
	private Button removeGirlfriendButton;
	private int GirlfriendsTotal = 1;

	@Override
	public void start(Stage s) throws Exception {

		stage = s;
		stage.setTitle("The Womanizer Best Friend");
		Image likeImage = new Image(getClass().getResourceAsStream("/resources/images/like.png"));
		stage.getIcons().add(likeImage);

		VBox root = new VBox();

		titleLabel = new Label("The Womanizer");
		titleLabel.setId("titleLabel");

		// Ich lade die Fonts
		titleLabel.setFont(Font.loadFont(getClass().getResource("/resources/font/Pacifico.ttf").toString(), 10));
		titleLabel.setFont(Font.loadFont(getClass().getResource("/resources/font/FrauncesItalic.ttf").toString(), 10));

		statusLabel = new Label();
		statusLabel.setId("statusLabel");
		updateStatusLabel(GirlfriendsTotal);

		HBox buttonsContainer = new HBox();
		buttonsContainer.getStyleClass().add("hBox");// css class

		addGirlfriendButton = new Button("Add Girlfriend".toUpperCase());
		addGirlfriendButton.setOnAction(e -> updateStatusLabel(++GirlfriendsTotal));

		removeGirlfriendButton = new Button("remove Girlfriend".toUpperCase());
		removeGirlfriendButton.setOnAction(e -> {
			if (GirlfriendsTotal > 0)
				updateStatusLabel(--GirlfriendsTotal);
		});

		buttonsContainer.getChildren().addAll(addGirlfriendButton, removeGirlfriendButton);
		root.getChildren().addAll(titleLabel, statusLabel, buttonsContainer);

		Scene scene = new Scene(root);
		// verbinde mit css Datei
		scene.getStylesheets().add(getClass().getResource("/resources/style/main.css").toString());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	private void updateStatusLabel(int z) {
		if (z < 2)
			statusLabel.setText("You have " + z + " girlfriend currently");
		else
			statusLabel.setText("You have " + z + " girlfriends currently");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
