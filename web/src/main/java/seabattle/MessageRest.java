package seabattle;/*
 * Copyright
 */


import com.sun.jdi.connect.spi.Connection;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.web.bind.annotation.*;
import seabattle.database.AuthorizationCrud;
import seabattle.database.authorizationJpa;

import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

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
        authorizationJpa results = new authorizationJpa("bAld","zavod.worker@mail.com","potato47");
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
    public final List<authorizationJpa> search2(@PathVariable String nick, @PathVariable String password){
        return aCrud.findByNicknameAndPasswordLike(nick, password);
    }
}

