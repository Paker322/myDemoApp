package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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

public static void main(String[] args) {
    port(getHerokuAssignedPort());

    get("/", (req, res) -> "Hello, World");

    post("/compute", (req, res) -> {
      //System.out.println(req.queryParams("input1"));
      //System.out.println(req.queryParams("input2"));

      String input1 = req.queryParams("input1");
      java.util.Scanner sc1 = new java.util.Scanner(input1);
      sc1.useDelimiter("[;\r\n]+");
      int[] inputList1 = new int[100];
      int i = 0;
      while (sc1.hasNext())
      {
        int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
        inputList1[i] = value;
        i++;
      }
      System.out.println(inputList1);

      String input2 = req.queryParams("input2");
      java.util.Scanner sc2 = new java.util.Scanner(input2);
      int[] inputList2 = new int[100];
       i = 0;
      while (sc2.hasNext())
      {
        int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
        inputList2[i] = value;
        i++;
      }
      System.out.println(inputList2);

      String input3 = req.queryParams("input3").replaceAll("\\s","");
      String input4= req.queryParams("input4").replaceAll("\\s","");

      boolean result = App.exep(inputList1,inputList2, input3,input4);

     Map map = new HashMap();
      map.put("result", result);
      return new ModelAndView(map, "compute.mustache");
    }, new MustacheTemplateEngine());

    get("/compute",
        (rq, rs) -> {
          Map map = new HashMap();
          map.put("result", "not computed yet!");
          return new ModelAndView(map, "compute.mustache");
        },
        new MustacheTemplateEngine());
}

static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
}
}



