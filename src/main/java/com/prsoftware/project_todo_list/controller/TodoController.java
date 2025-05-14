package com.prsoftware.project_todo_list.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prsoftware.project_todo_list.entity.Todo;
import com.prsoftware.project_todo_list.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService; //Chamando a Classe de Serviços Criado Com o Metodos de CRUD

    //Criando o Construtor da Classe de Service
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //Criando o Metodo de Criar Todo - Com o Parametro POST
    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    //Criando o Metodo de Listar as Todo - Com o Parametro GET
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    

    //Criando o Metodo de Update para as Todo - Com o Parametro PUT
    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }


    //Criando o Metodo de Delete para as Todo - Com o Parametro DELETE
    //Está sendo enviada uma ID via parametro dentro do metodo, para saber qual Todo vai se Excluida
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }


}
