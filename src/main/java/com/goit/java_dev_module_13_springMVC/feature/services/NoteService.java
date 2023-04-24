package com.goit.java_dev_module_13_springMVC.feature.services;

import com.goit.java_dev_module_13_springMVC.feature.entities.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {
    private static Map<Long, Note> noteList = new LinkedHashMap<>();

    public List<Note> listAll() {
        return noteList.values().stream().toList();
    }

    public Note add(Note note) {
        note.setId(note.hashCode());
        noteList.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteList.containsKey(id)) {
            throw new IllegalArgumentException("Note with id: " + id + "doesn't exist!");
        }
        noteList.remove(id);
    }

    public void update(Note note) {
        if (!noteList.containsKey(note.getId())) {
            throw new IllegalArgumentException("Note with id: " + note.getId() + "doesn't exist!");
        }
        noteList.put(note.getId(), note);
    }

    public Note getById(long id) {
        if (!noteList.containsKey(id)) {
            throw new IllegalArgumentException("Note with id: " + id + "doesn't exist!");
        }
        return noteList.get(id);
    }
}
