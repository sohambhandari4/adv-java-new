// Write a SERVLET program to Design an HTML page containing 4 option buttons 
//(Painting, Drawing, Singing and swimming) and 2 buttons reset and submit. When the user 
//clicks submit, the server responds by adding cookie containing the selected hobby and sends 
//the HTML page to the client. Program should not allow duplicate cookies to be written.
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HobbyServlet")
public class HobbyServlet extends HttpServlet
 {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve selected hobby from request parameter
        String hobby = request.getParameter("hobby");
        Cookie[] cookies = request.getCookies();
        boolean cookieExists = false;
        if (cookies != null)
         {
            for (Cookie cookie : cookies)
             {
                if (cookie.getName().equals("hobby") && cookie.getValue().equals(hobby))
                 {
                    cookieExists = true;
                    break;
                }
            }
        }
        // If cookie doesn't exist, create a new one and add it to the response
        if (!cookieExists)
         {
            Cookie hobbyCookie = new Cookie("hobby", hobby);
            response.addCookie(hobbyCookie);
        }

        // Display HTML page with the selected hobby
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Selected Hobby</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Selected Hobby: " + hobby + "</h2>");
        out.println("<form action=\"HobbyServlet\" method=\"post\">");
        out.println("<input type=\"radio\" name=\"hobby\" value=\"Painting\"> Painting<br>");
        out.println("<input type=\"radio\" name=\"hobby\" value=\"Drawing\"> Drawing<br>");
        out.println("<input type=\"radio\" name=\"hobby\" value=\"Singing\"> Singing<br>");
        out.println("<input type=\"radio\" name=\"hobby\" value=\"Swimming\"> Swimming<br>");
        out.println("<input type=\"reset\" value=\"Reset\">");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
