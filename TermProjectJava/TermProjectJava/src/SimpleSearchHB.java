import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Recipes;
import util.Info;
import util.UtilDBOrn;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Recipes> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = UtilDBOrn.listEmployees(keyword);
      } else {
         listEmployees = UtilDBOrn.listEmployees();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Recipes> listEmployees, PrintWriter out) {
      for (Recipes employee : listEmployees) {
         System.out.println("[DBG] " + employee.getId() + ", " //
               + employee.getName() + ", " //
               + employee.getIngredients() + ", " //
               + employee.getInstructions());

         out.println("<li><h2>" + employee.getName()); 
         out.println("<br><h4>Ingredients: " + employee.getIngredients());
         String[] instructions = employee.getInstructions().split("\\.");
         for(int i = 0; i < instructions.length; i++) {
             out.println("<br>" + instructions[i]);
         }
         out.println("</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
