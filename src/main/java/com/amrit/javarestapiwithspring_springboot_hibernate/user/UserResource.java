package com.amrit.javarestapiwithspring_springboot_hibernate.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController // because, it is a rest API
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User>retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id){
        User user = service.findById(id);

        if(user==null){
            throw new UserNotFoundException("id:"+id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        // To add the links to some other url
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id){
        service.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@Valid @RequestBody User user){ // creating post method to add a new user details
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();// location will contain the get url for the newly created user,
        // in talend api tester

        return ResponseEntity.created(location).build(); // this will change response status from 200 to 201 which is created
        // response status
    }
}
