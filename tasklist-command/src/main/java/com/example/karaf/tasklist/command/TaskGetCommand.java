package com.example.karaf.tasklist.command;

import com.example.karaf.tasklist.model.Task;
import com.example.karaf.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@OsgiServiceProvider(classes=TaskGetCommand.class)
@Properties(
        {
                @Property(name = "osgi.command.scope", value = "task"),
                @Property(name = "osgi.command.function", value = "get")
        })
public class TaskGetCommand {
    @Inject
    @OsgiService
    private TaskService taskService;

    public Task get(String id) throws Exception {
        return taskService.getTask(id);
    }
}
