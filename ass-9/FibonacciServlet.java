//Write SERVLET Program in java to accept number from user and display Fibonacci series
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet
 {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
             {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the number from request parameter
        int num = Integer.parseInt(request.getParameter("number"));

        // Display Fibonacci series
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fibonacci Series</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Fibonacci Series</h2>");
        out.println("<p>Number: " + num + "</p>");
        out.println("<p>Fibonacci Series:</p>");
        for (int i = 0; i < num; i++) 
        {
            out.print(fibonacci(i) + " ");
        }
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    // Method to calculate Fibonacci series
    private int fibonacci(int n) 
    {
        if (n <= 1)
         {
            return n;
        }
         else
          {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
