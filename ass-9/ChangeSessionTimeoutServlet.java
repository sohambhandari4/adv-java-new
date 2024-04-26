//Write a SERVLET program to change inactive time interval of session
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeSessionTimeoutServlet")
public class ChangeSessionTimeoutServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
             {
        // Get the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);// 5 min 
        response.setContentType("text/html");

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Session Timeout Changed</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Session Timeout Changed Successfully</h2>");
        response.getWriter().println("<p>The inactive time interval of the session has been set to 5 minutes.</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
