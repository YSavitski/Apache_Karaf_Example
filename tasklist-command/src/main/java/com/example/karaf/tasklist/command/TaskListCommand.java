package com.example.karaf.tasklist.command;

import org.apache.karaf.shell.support.table.ShellTable;

import com.example.karaf.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@OsgiServiceProvider(classes=TaskListCommand.class)
@Properties(
        {
                @Property(name = "osgi.command.scope", value = "task"),
                @Property(name = "osgi.command.function", value = "list")
        })
public class TaskListCommand {
    @Inject
    @OsgiService
    private TaskService taskService;

    public void list(){
        ShellTable table = new ShellTable();
        table.column("id");
        table.column("title");
        taskService.getTasks().forEach(task -> table.addRow().addContent(task.getId(), task.getTitle()));
        table.print(System.out);
    }
}
