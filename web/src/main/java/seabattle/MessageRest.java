package seabattle;/*
 * Copyright
 */


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import seabattle.business.Factorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seabattle.database.AuthorizationCrud;
import seabattle.database.authorizationJpa;

import java.util.List;

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

    private final Factorial factorial;
    @GetMapping("/message")
    @Override
    public final String getMessage() {
        return "My first string!";
    }
    /**
     * List of factorials.
     */
    private final List<Factorial> factorials;

    /**
     * Default contructor.
     * @param factorial Factorial calculator instance.
     * @param factorials List if factorials calculators.
     */
    private final ObjectProvider<FactorialResults> provider;
    final AuthorizationCrud aCrud;
    @Autowired
    public MessageRest(
            @Qualifier("flatFactorial") final Factorial factorial,
            final List<Factorial> factorials,
            final ObjectProvider<FactorialResults> provider, final AuthorizationCrud aCrud) {
        this.factorial = factorial;
        this.factorials = factorials;
        this.provider = provider;
        this.aCrud = aCrud;
    }

    @GetMapping("/factorial")
    public final int getFactorial() {
        final int defaultval = 5;
        return this.factorial.calculate(defaultval);
    }

    @GetMapping("/smartFactorial")
    public final int smartFactorial() {
        final int defaultval = 5;
        int ret = 0;
        for (final Factorial fact : this.factorials) {
            if (fact.canApply(defaultval)) {
                ret = fact.calculate(defaultval);
                break;
            }
        }
        return ret;
    }
    @GetMapping("/fInform")
    public final FactorialResults withInformation() {
        final int defaultval = 3;
        FactorialResults results = null;
        for (final Factorial fact : this.factorials) {
            if (fact.canApply(defaultval)) {
                results = this.provider.getObject(
                        fact.calculate(defaultval),
                        fact.getClass().getSimpleName()
                );
                break;
            }
        }
        return results;
    }
    @GetMapping("/auth")
    public final authorizationJpa userInfo() {
        String pass = "123qwe";
        authorizationJpa results = new authorizationJpa("anof1r","denis.a@123.com","qwe123");
        return aCrud.save(results);
    }
}
