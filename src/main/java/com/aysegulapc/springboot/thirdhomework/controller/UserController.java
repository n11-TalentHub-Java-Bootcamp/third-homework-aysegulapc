package com.aysegulapc.springboot.thirdhomework.controller;

import com.aysegulapc.springboot.thirdhomework.entity.User;
import com.aysegulapc.springboot.thirdhomework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public MappingJacksonValue findAllUserList() {
        List<User> userList = userService.findAll();
        MappingJacksonValue mapping = new MappingJacksonValue(userList);
        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findUserById(@PathVariable String id) {
        User user = userService.findById(id);
        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllUserList()
        );

        EntityModel entityModel = EntityModel.of(user);
        entityModel.add(linkToProduct.withRel("all-users"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        return mapping;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User user){
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }
}
