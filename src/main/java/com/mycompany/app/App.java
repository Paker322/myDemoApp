package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{



public static boolean exep(int[] prob, int[] value, String exp, String exp1) {
    if (prob.length != value.length) {
        System.out.println("hatali array");
        return false ;
    }
    int ex = 0;

    for (int i = 0; i < prob.length; i++)
    {
        ex = ex + prob[i] * value[i];
    }
    if (!(Integer.parseInt(exp) >= ex && ex >=Integer.parseInt(exp1) ) )
        return false;

    return true;
}
}