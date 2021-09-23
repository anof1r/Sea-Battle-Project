package seabattle;

import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class TurnChangeController {

    volatile String username = null;

    public TurnChangeController(){}

    public String getUsername(){
        return this.username;
    }
}
