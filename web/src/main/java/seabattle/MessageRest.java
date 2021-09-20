package seabattle;/*
 * Copyright
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seabattle.database.AuthorizationCrud;
import seabattle.database.authorizationJpa;

import java.security.Principal;
import java.util.*;


/**
 * Rest implementation of controller.
 *
 *
 * l,s
 * @since 0.0.1
 */

@CrossOrigin
@RestController

@RequestMapping("test")
public class MessageRest implements MessageController {


    public MessageRest(AuthorizationCrud aCrud) {
        this.aCrud = aCrud;
    }

    @GetMapping("/message")
    @Override
    public final String getMessage() {
        return "My first string!";
    }

    final AuthorizationCrud aCrud;


    @GetMapping("/auth")
    public final authorizationJpa userInfo() {
        authorizationJpa results = new authorizationJpa("NoPassBoyy","dontusepass@mail.com","");
        return aCrud.save(results);
    }
    @GetMapping("/search/{id}")
    public final Optional<authorizationJpa> search(@PathVariable int id){
        return aCrud.findById(id);
    }
    @GetMapping("/searchALL")
    public final Iterable<authorizationJpa> search (){
        return aCrud.findAll();
    }
    @GetMapping("/eap/{nick},{password}")
    public final authorizationJpa search2(@PathVariable String nick, @PathVariable String password){
        return aCrud.findByNicknameAndPasswordLike(nick, password);
    }
    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World!!");
        return model;
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}

