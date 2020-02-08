package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

//import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void test2Found() {
        int [] arrayv = new int[]{1,2,3,4};
        int [] arrayp = new int[]{1,2,3,4};
        String exp1 = "35";
        String exp2 = "20";
        assertTrue(new App().exep(arrayv,arrayp,exp1,exp2));
      }
  
      public void testNotFound() {
        int [] arrayv = new int[]{1,2,3,4};
        int [] arrayp = new int[]{1,2,3,4};
        String exp1 = "20";
        String exp2 = "40";
        assertTrue(new App().exep(arrayv,arrayp,exp1,exp2));
      }
  
      public void testLongArray() {
        int [] arrayv = new int[]{1,2,3,4};
        int [] arrayp = new int[]{1,2,3,4,5,6,7};
        String exp1 = "35";
        String exp2 = "20";
        assertTrue(new App().exep(arrayv,arrayp,exp1,exp2));
      }
      public void testOneTrueArray() {
        int [] arrayv = new int[]{1,2,3,4};
        int [] arrayp = new int[]{1,2,3,4};
        String exp1 = "29";
        String exp2 = "20";
        assertTrue(new App().exep(arrayv,arrayp,exp1,exp2));
      }     
      
      public void testNullArray() {
        int [] arrayv = new int[]{1,2,3,4};
        int [] arrayp = new int[]{};
        String exp1 = "35";
        String exp2 = "20";
        assertTrue(new App().exep(arrayv,arrayp,exp1,exp2));
      }
}
