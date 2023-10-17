package br.com.michaelbernard.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired /* Spring gerencia a instância do repositório */
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel) { /* Definir que esse atributo vem dentro do RequestBody, se não ele não sabe de onde vem */
        var task = this.taskRepository.save(taskModel);
        return task;
    }
}