// Write a SERVLET program that provides information about a HTTP request from a 
//client, such as IP address and browser type. The servlet also provides information about the 
//server on which the servlet is running, such as the operating system type, and the names of 
//currently loaded servlets.
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet
 {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
             {
                
        // Get client's IP address and browser type
        String clientIPAddress = request.getRemoteAddr();
        String browserType = request.getHeader("User-Agent");

        // Get server's information
        String serverOS = System.getProperty("os.name");
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        // Get servlet names
        String[] servletNames = getServletContext().getServletRegistrations().keySet().toArray(new String[0]);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display information
        out.println("<html>");
        out.println("<head><title>Request Information</title></head>");
        out.println("<body>");
        out.println("<h2>Client Information</h2>");
        out.println("<p>Client IP Address: " + clientIPAddress + "</p>");
        out.println("<p>Browser Type: " + browserType + "</p>");
        out.println("<h2>Server Information</h2>");
        out.println("<p>Server Operating System: " + serverOS + "</p>");
        out.println("<p>Server Name: " + serverName + "</p>");
        out.println("<p>Server Port: " + serverPort + "</p>");
        out.println("<h2>Currently Loaded Servlets</h2>");
        out.println("<ul>");
        for (String servletName : servletNames) {
            out.println("<li>" + servletName + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
