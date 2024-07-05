package com.example.westpackhackathon.controller;

import com.example.westpackhackathon.ApplicationInfo;
import com.example.westpackhackathon.MainApplication;
import com.example.westpackhackathon.model.MessageDisplay;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatbotController {
    MessageDisplay mD;
    @FXML
    private ListView<MessageDisplay.ChatEntry> MessagesListView;
    @FXML
    private TextField MessageTextField;
    @FXML
    private Button SendButton;
    @FXML
    private Button HomeButton;
    @FXML
    private Button ChatbotButton;
    private ListCell<MessageDisplay.ChatEntry> renderCell(ListView<MessageDisplay.ChatEntry> chatListView) {
        return new ListCell<>() {
            HBox graphic = new HBox();
            Text message = new Text();

            @Override
            protected void updateItem(MessageDisplay.ChatEntry item, boolean empty) {
                graphic.getChildren().add(message);
                super.updateItem(item, empty);
                if (!empty && (item != null)) {
                    message.setText(item.textProperty().get());
                    graphic.setAlignment(item.typeProperty().get().equals(MessageDisplay.MessageType.BOT) ? Pos.CENTER_LEFT : Pos.CENTER_RIGHT);
                    setGraphic(graphic);
                } else {
                    message.setText("");
                    setGraphic(null);
                }
            }
        };
    }
    public ChatbotController() {
        mD = new MessageDisplay();
        mD.messages = FXCollections.observableArrayList();
        MessagesListView.setCellFactory(list -> new MessageDisplay.ChatCell());
        MessagesListView.setItems(mD.messages);
    }
    public void onSendButtonClick() throws IOException {
        mD.messages.add(new MessageDisplay.ChatEntry(MessageTextField.getText(), MessageDisplay.MessageType.USER));
    }
    public void onHomeButtonClick() throws IOException {
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WIDTH, ApplicationInfo.HEIGHT);
        stage.setScene(scene);
    }
    public void onChatbotButtonClick() throws IOException {
        Stage stage = (Stage) ChatbotButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("chatbotpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ApplicationInfo.WIDTH, ApplicationInfo.HEIGHT);
        stage.setScene(scene);
    }
}
