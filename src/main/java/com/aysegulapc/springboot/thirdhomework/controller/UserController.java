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

    /** This endpoint gets all user according to json format.
     * This endpoint was written for item 1 of question 3 in the homework.
     * @return MappingJacksonValue
     * **/
    @GetMapping("")
    public MappingJacksonValue findAllUserList() {
        List<User> userList = userService.findAll();
        MappingJacksonValue mapping = new MappingJacksonValue(userList);
        return mapping;
    }

    /** This endpoint gets a specific user by id according to json format.
     * This endpoint was written for item 2 of question 3 in the homework.
     * @return MappingJacksonValue
     * **/
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

    /** This endpoint save a user to mongodb.
     * This endpoint was written for item 3 of question 3 in the homework.
     * @return ResponseEntity<Object>
     * **/
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User user){
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /** This endpoint delete a user from mongodb.
     * This endpoint was written for item 4 of question 3 in the homework.
     * **/
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }
}
