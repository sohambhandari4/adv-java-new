import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the array of cookies associated with this request
        Cookie[] cookies = request.getCookies();

        // Check if the user has visited the page before
        boolean isFirstVisit = true;
        int visitCount = 1;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    isFirstVisit = false;
                    visitCount = Integer.parseInt(cookie.getValue()) + 1;
                    cookie.setValue(Integer.toString(visitCount));
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        // If it's the first visit, create a new cookie and display welcome message
        if (isFirstVisit) {
            Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
            visitCookie.setMaxAge(24 * 60 * 60); // Cookie will expire in 24 hours
            response.addCookie(visitCookie);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Welcome</title></head>");
            out.println("<body>");
            out.println("<h2>Welcome to our website!</h2>");
            out.println("<p>This is your first visit.</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // Display the number of times visited
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Visit Counter</title></head>");
            out.println("<body>");
            out.println("<h2>Visit Counter</h2>");
            out.println("<p>You have visited this page " + visitCount + " times.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
