package Tests;

import org.junit.jupiter.api.Test;
import FDTheory.FDParser;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Umar on 12/30/2016.
 */
class FDParserTest {
    @Test
    void parseFDs() {
        String rawfds = "AC->F;\n" +
                "CEF -> B;     C ->D;\n" +
                "DC ->A;";
        String[] fds = {"ac->f", "cef->b", "c->d", "dc->a"};
        assertArrayEquals(FDParser.parseFDs(rawfds), fds);
    }
}