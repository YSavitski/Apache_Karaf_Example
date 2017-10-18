package com.example.karaf.tasklist.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class Task implements Serializable{
    private static final long serialVersionUID = 940421758002766534L;

    String id;
    String title;
    String description;
    Date/*LocalDateTime*/ dueDate;
    boolean finished;
}
