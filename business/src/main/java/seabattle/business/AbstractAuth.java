package seabattle.business;
import seabattle.database.*;

public abstract class AbstractAuth implements auth {

    private final AuthorizationCrud results;

    protected AbstractAuth(final AuthorizationCrud results) {
        this.results = results;
    }

}
