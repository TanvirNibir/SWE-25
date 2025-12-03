package java6_4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java6_4.model.Note;
import java6_4.model.Notebook;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private ListView<Note> notesList;

    private Notebook notebook;

    @FXML
    private void initialize() {
        notebook = new Notebook();
        notesList.setItems(notebook.getNotes());
        addButton.setOnAction(event -> addNote());
    }

    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            titleField.clear();
            contentArea.clear();
        }
    }
}
