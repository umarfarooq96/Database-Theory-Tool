package FDTheory;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Umar on 1/3/2017.
 */
class ClosureComputerTest {


    @Test
    void computeClosure() {
        String[] fds = {"ac->f", "cef->b", "c->d", "dc->a"};
        ClosureComputer c = new ClosureComputer(fds);
        assertEquals(c.computeClosure("c"), "acdf");
        assertEquals(c.computeClosure("acd"), "acdf");
        assertEquals(c.computeClosure("b"), "b");

    }


    @Test
    void populateHashMap() {
        //No need to over test this for all intents and purposes...
        String[] fds = {"a->b", "a->c", "b->d", "ab->ef"};
        ClosureComputer c = new ClosureComputer(fds);
        HashMap<String, String> expect = new HashMap<String, String>();
        expect.put("a", "bc");
        expect.put("ab", "ef");
        expect.put("b", "d");
        assertEquals(expect, c.getFDs());
    }

}