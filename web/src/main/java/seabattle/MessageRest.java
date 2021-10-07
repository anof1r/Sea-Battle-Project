package seabattle;/*
 * Copyright
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seabattle.database.AuthorizationCrud;
import seabattle.database.authorizationJpa;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
@RequestMapping("rest")
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
    Principal user;
    TurnChangeController controller = new TurnChangeController();

    /*
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
     */
    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpSession user){
         user.invalidate();
         return ResponseEntity.ok("{}");
    }


    @RequestMapping("/startGame")
    public String startGame(Principal user) {
        if (controller.player == null){
            controller.player = user;
            return "{}";
        }
        else {
            if (controller.player.getName() != user.getName()) {
                controller.game = new Game(controller.player, user);
                controller.player = null;
                return "{\"game\": 123}";
            }
            else{
                return "{}";
            }
        }
    }
    @RequestMapping("/getGame")
    public String getGame(Principal user) {
        if (controller.player == null){
            return "{\"game\": 123}";
        }
        else{
            return "{}";
        }
    }

    @RequestMapping("/getGameField")
    public char[][] getField(Principal user){
        return controller.game.field;
    }
    @RequestMapping("/checkTurn")
    public ResponseEntity<String> getTurn(Principal user) {
        if (controller.game.checkTurnOrder(user)) {
            return ResponseEntity.ok("{\"isMyTurn\": true}");
        }
        return ResponseEntity.ok("{}");
    }


    @GetMapping("/turn/{x},{y}")
    public char[][] makeTurn(Principal user, @PathVariable int x, @PathVariable int y){
        controller.game.turn(user,x,y);
        return controller.game.field;
    }
}
