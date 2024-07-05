package com.example.westpackhackathon.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MessageDisplay {
    public ObservableList<ChatEntry> messages;
    public enum MessageType {
        BOT, USER
    }

    public static class ChatCell extends ListCell<ChatEntry> {

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
}
