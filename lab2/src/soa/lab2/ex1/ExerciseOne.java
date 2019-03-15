package soa.lab2.ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExerciseOne", urlPatterns = "/ex1")
public class ExerciseOne extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String num3 = request.getParameter("num3");
    String num4 = request.getParameter("num4");
    String num5 = request.getParameter("num5");
    String num6 = request.getParameter("num6");
    String num7 = request.getParameter("num7");
    String num8 = request.getParameter("num8");
    String num9 = request.getParameter("num9");
    String num10 = request.getParameter("num10");

    StringBuilder strb = new StringBuilder();
    Stream.of(
        num1,
        num2,
        num3,
        num4,
        num5,
        num6,
        num7,
        num8,
        num9,
        num10
    )
        .filter(s -> !s.equals(""))
        .filter(s -> s.chars().allMatch(Character::isDigit))
        .map(Integer::parseInt)
        .sorted(Integer::compareTo)
        .forEach(i -> {
          strb.append(i).append(" ");
        });

    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>ExerciseOne</title></head>");
    out.println("<body>");
    out.println("<p>Nums are: " + strb.toString() + "</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String num3 = request.getParameter("num3");
    String num4 = request.getParameter("num4");
    String num5 = request.getParameter("num5");

    List<Integer> numbers = Arrays.asList(num1, num2, num3, num4, num5).stream()
        .map(Integer::parseInt).collect(Collectors.toList());

    Integer sum = numbers.stream().reduce((a, b) -> a + b).get();
    Integer mean = sum / 5;

    out.println("<html>");
    out.println("<head><title>ExerciseOne</title></head>");
    out.println("<body>");
    out.println("<p>Nums are: " + String
        .format("1: %s, 2: %s, 3: %s, 4: %s, 5: %s ", num1, num2, num3, num4, num5) + "</p>");
    out.println("<p>Mean is: " + mean + "</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
