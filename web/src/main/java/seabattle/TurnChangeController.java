package seabattle;

import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class TurnChangeController {
    public volatile Principal player;
    public volatile Game game;
    public TurnChangeController(){}


}
