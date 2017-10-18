package com.example.karaf.tasklist.persistence;

import com.example.karaf.tasklist.model.Task;
import com.example.karaf.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@OsgiServiceProvider(classes = TaskService.class)
@Properties(@Property(name = "service.exported.interfaces", value = "*"))
@Singleton
public class TaskServiceImpl implements TaskService {
    Map<String, Task> taskMap;

    public TaskServiceImpl() {
        taskMap = new HashMap<>();
        Task task = new Task();
        task.setId("1");
        task.setTitle("Buy some coffee");
        task.setDescription("Take the extra strong");
        //task.setDueDate(LocalDateTime.now());
        addTask(task);
        task = new Task();
        task.setId("2");
        task.setTitle("Finish karaf tutorial");
        task.setDescription("Last check and wiki upload");
        //task.setDueDate(LocalDateTime.now());
        addTask(task);
    }

    @Override
    public Task getTask(String id) {
        return taskMap.get(id);
    }

    @Override
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public Collection<Task> getTasks() {
        return new ArrayList<>(taskMap.values());
    }

    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void deleteTask(String id) {
        taskMap.remove(id);
    }
}
