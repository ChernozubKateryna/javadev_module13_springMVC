package com.goit.java_dev_module_13_springMVC.feature.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Note {
    @Id
    private long id;

    private String title;

    private String content;
}
