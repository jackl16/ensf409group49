package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QueriesHandlingTest {
    @Test
    //Contructor created with three arguments
    //Use getDBURL to obtain a value
    public void testConstructor3getDBURL(){
        String Url="jdbc:mysql://localhost/inventory";
        QueriesHandling testObj = new QueriesHandling(Url,"ENSF409","ensf409");
        
        //get DBURL from testObj
        String DBURL = testObj.getDBURL();

        assertTrue("Getting DBURL failed.",Url.equals(DBURL) );

    }

    @Test
    //Contructor created with three arguments
    //Use getUSERNAME to obtain a value
    public void testConstructor3getUSERNAME(){
        String User="ENSF409";
        QueriesHandling testObj = new QueriesHandling("jdbc:mysql://localhost/inventory",User,"ensf409");
        
        //get USERNAME from testObj
        String USERNAME = testObj.getUSERNAME();

        assertTrue("Getting USERNAME failed.",User.equals(USERNAME));

    }

    @Test
    //Contructor created with three arguments
    //Use getUSERNAME to obtain a value
    public void testConstructor3getPASSWORD(){
        String Pass="ensf409";
        QueriesHandling testObj = new QueriesHandling("jdbc:mysql://localhost/inventory","ENSF409",Pass);
        
        //get USERNAME from testObj
        String PASSWORD = testObj.getPASSWORD();

        assertTrue("Getting USERNAME failed.",Pass.equals(PASSWORD));

    }

}


