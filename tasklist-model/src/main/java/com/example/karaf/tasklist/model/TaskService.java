package com.example.karaf.tasklist.model;

import java.util.Collection;

public interface TaskService {
    Task getTask(String id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(String id);
    Collection<Task> getTasks();
}
