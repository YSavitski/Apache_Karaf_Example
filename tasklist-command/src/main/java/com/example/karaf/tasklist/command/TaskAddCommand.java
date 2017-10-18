package com.example.karaf.tasklist.command;

import com.example.karaf.tasklist.model.Task;
import com.example.karaf.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
@OsgiServiceProvider(classes=TaskAddCommand.class)
@Properties(//
        {
                @Property(name = "osgi.command.scope", value = "task"),
                @Property(name = "osgi.command.function", value = "add")
        })
public class TaskAddCommand {
    @Inject
    @OsgiService
    private TaskService taskService;

    public void add(String id, String title, String description) throws Exception {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        /*task.setDueDate(LocalDateTime.now());*/
        taskService.addTask(task);
    }
}
