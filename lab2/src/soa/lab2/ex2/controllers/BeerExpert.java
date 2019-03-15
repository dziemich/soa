package soa.lab2.ex2.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import soa.lab2.ex2.models.BeerCompany;

@WebServlet(name = "BeerExpert", urlPatterns = {"/ex2/pickbeer"})
public class BeerExpert extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String beerColor = request.getParameter("beerColor");
    String fancy = request.getParameter("isFancy");
    String alcoholFree = request.getParameter("isAlcoholFree");
    PrintWriter out = response.getWriter();

    if (beerColor.equals("") || fancy.equals("") || alcoholFree.equals("")){
      out.println("fields can't be null");
      out.close();
      return;
    }
    if (!(fancy.equals("true") || fancy.equals("false") && (alcoholFree.equals("true") || alcoholFree.equals("false")))){
      out.println("determine fields fancy and alcochol free as true/false");
      out.close();
      return;
    }

    Boolean isFancy = Boolean.parseBoolean(fancy);
    Boolean isAlcoholFree = Boolean.parseBoolean(alcoholFree);

    BeerCompany beerCompany = determinePreferredBeerCompany(beerColor, isFancy, isAlcoholFree);

    out.println("<html>");
    out.println("<head><title>ExerciseOne</title></head>");
    out.println("<body>");
    out.println("<p>Your preffered beer is: " + beerCompany.toString() + "!</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();

  }

  BeerCompany determinePreferredBeerCompany(String beerColor, Boolean isFancy, Boolean isAlcoholFree){
    if (beerColor.equals("jasne") && ! isFancy & !isAlcoholFree) return BeerCompany.TYSKIE;
    else if(beerColor.equals("ciemne") && isFancy && !isAlcoholFree) return BeerCompany.KSIAZECE_DARK;
    else if(beerColor.equals("metne") && isFancy && !isAlcoholFree) return BeerCompany.KSIAZECE_WHEAT;
    else if(beerColor.equals("jasne") && !isFancy && isAlcoholFree) return BeerCompany.LECH_FREE;
    else if(beerColor.equals("jasne") && isFancy && !isAlcoholFree) return BeerCompany.GRODZISKA_IPA;
    return BeerCompany.CACTUS_JUICE;
  }
}
