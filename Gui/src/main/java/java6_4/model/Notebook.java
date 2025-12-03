package java6_4.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    private final ObservableList<Note> notes;

    public Notebook() {
        this.notes = FXCollections.observableArrayList();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }
}
