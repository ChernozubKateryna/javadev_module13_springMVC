package com.goit.java_dev_module_13_springMVC.feature.controllers;

import com.goit.java_dev_module_13_springMVC.feature.entities.Note;
import com.goit.java_dev_module_13_springMVC.feature.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    @Autowired
    private final NoteService noteService;

    @GetMapping("/add")
    public ModelAndView getNoteAdd() {
        ModelAndView result = new ModelAndView("addNote");
        result.addObject("note", null);
        return result;
    }

    @PostMapping("/add")
    public RedirectView postNoteAdd(@RequestParam String title, @RequestParam String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new RedirectView("/note/list");
    }

    @GetMapping("/list")
    public ModelAndView getNoteList() {
        ModelAndView result = new ModelAndView("noteList");
        result.addObject("noteList", noteService.listAll());
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView getNoteById(@RequestParam long id) {
        ModelAndView result = new ModelAndView("editNote");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public RedirectView postNoteEdit(@RequestParam(value = "id") Long id,
                                 @RequestParam(value = "title") String title,
                                 @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new RedirectView("/note/list");
    }

    @PostMapping("/delete")
    public RedirectView postNoteDelete(@RequestParam long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }
}