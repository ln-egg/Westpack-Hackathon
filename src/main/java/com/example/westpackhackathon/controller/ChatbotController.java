package com.example.westpackhackathon.controller;

import com.example.westpackhackathon.ApplicationInfo;
import com.example.westpackhackathon.MainApplication;
import com.example.westpackhackathon.model.ChatBot;
import com.example.westpackhackathon.model.ChatbotString;
import com.example.westpackhackathon.model.MessageType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ChatBot Cleo;
    private ObservableList<ChatEntry> messages;
    @FXML
    private ListView<ChatEntry> MessagesListView;
    @FXML
    private TextField MessageTextField;
    @FXML
    private Button SendButton;
    @FXML
    private Button HomeButton;
    @FXML
    private Button ChatbotButton;
    static class ChatCell extends ListCell<ChatEntry> {

        HBox graphic = new HBox();
        Text message = new Text();

        public ChatCell() {
            graphic.getChildren().add(message);
            graphic.setStyle("-fx-background: white;");
        }

        @Override
        public void updateItem(ChatEntry item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty && (item != null)) {
                message.setText(item.textProperty().get());
                graphic.setAlignment(item.typeProperty().get().equals(MessageType.BOT) ? Pos.CENTER_LEFT : Pos.CENTER_RIGHT);
                setGraphic(graphic);
            } else {
                message.setText("");
                setGraphic(null);
            }
        }
    }
    public static class ChatEntry {
        private final StringProperty text = new SimpleStringProperty("");
        private final ObjectProperty<MessageType> type = new SimpleObjectProperty<>();
        public ChatEntry(String text, MessageType type) {
            this.text.set(text);
            this.type.set(type);
        }
        public StringProperty textProperty() {
            return text;
        }
        public ObjectProperty<MessageType> typeProperty() {
            return type;
        }
    }
    @FXML
    public void initialize() {
        Cleo = new ChatBot();
        SendButton.setOnAction(event -> {
            try {
                onSendButtonClick();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        messages = FXCollections.observableArrayList();
        MessagesListView.setCellFactory(list -> new ChatCell());
        MessagesListView.setItems(messages);
        messages.add(new ChatEntry(ChatbotString.StartQuestion, MessageType.BOT));
        messages.add(new ChatEntry(ChatbotString.StartOption, MessageType.BOT));
        messages.add(new ChatEntry(ChatbotString.ChoicePrompt, MessageType.BOT));
    }
    public void onSendButtonClick() throws IOException {
        String message = MessageTextField.getText();
        messages.add(new ChatEntry(message, MessageType.USER));
        switch(Cleo.getState()) {
            case -1:
                String temp = "Restarting...";
                messages.add(new ChatEntry(temp, MessageType.BOT));
                messages.add(new ChatEntry(ChatbotString.StartQuestion, MessageType.BOT));
                messages.add(new ChatEntry(ChatbotString.StartOption, MessageType.BOT));
                messages.add(new ChatEntry(ChatbotString.ChoicePrompt, MessageType.BOT));
            case 0:
                try {
                    messages.add(new ChatEntry(Cleo.Choices(Integer.parseInt(message)), MessageType.BOT));
                } catch(Exception e) {
                    messages.add(new ChatEntry(e.getMessage(), MessageType.BOT));
                }
                break;
            case 1:
                break;
            default:
                break;
        }
        MessageTextField.clear();
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
