package com.logika.helpers.logichelper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class parseLogicsTest {
        @Test
        void testParseLogic() {
                assertArrayEquals(List.of("~(~p&q)", "&", "~p").toArray(),
                                ParseLogics.parseLogic("~(~p&q)&~p").toArray());

                assertArrayEquals(List.of("(~p&q)").toArray(),
                                ParseLogics.parseLogic("(~p&q)").toArray());

                assertArrayEquals(List.of("~(~p&~q)").toArray(),
                                ParseLogics.parseLogic("~(~p&~q)").toArray());
                assertArrayEquals(List.of("p&q").toArray(),
                                ParseLogics.parseLogic("p&q").toArray());
        }

        @Test
        void testCheckStartWith() {
                var parseLogics = new ParseLogics();
                assertTrue(parseLogics.checkStartWith("&tttttt"));
                assertTrue(parseLogics.checkStartWith("|tttttt"));
                assertTrue(parseLogics.checkStartWith("-tttttt"));
                assertTrue(parseLogics.checkStartWith("#tttttt"));
                assertFalse(parseLogics.checkStartWith("ttttttt"));
        }
}
