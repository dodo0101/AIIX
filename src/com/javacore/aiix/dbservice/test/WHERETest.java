package com.javacore.aiix.dbservice.test;

import com.javacore.aiix.dbservice.data.query.WHEREParser;

public class WHERETest {

    public static final String VALID_STRING_1 = "WHERE id = 1";
    public static final String VALID_STRING_2 = "   WHERE     id = 1 AND name= Tony    ";
    public static final String inVALID_STRING_1 = "BAD WHERE";
    public static final String inVALID_STRING_2 = "WHERE ID = 1 AND";


    static WHEREParser parser = new WHEREParser();

    @Test(enabled = false)
    public static void testValidString () {
        assert parser.validate(VALID_STRING_1 ) : VALID_STRING_1 ;
    }

    @Test
    public static void testInValidString() {
        assert !parser.validate(inVALID_STRING_1) :inVALID_STRING_1;
    }

    //@Test
    public static void testBeatifyValid() {
        assert parser.beautify(VALID_STRING_2).equals("WHERE id = 1 AND name= Tony"); //WHY??
    }

    @Test
    public static void testExtractClause(){
        assert parser.extractClause(VALID_STRING_1).equals(" id = 1");
        assert parser.extractClause(VALID_STRING_2).equals("   WHERE     id = 1 AND name= Tony    ");
    }


}
