//Write a SERVLET program in java to accept details of student (SeatNo, Stud_Name, 
//Class, Total_Marks). Calculate percentage and grade obtained and display details on page.
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
             {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve student details from request parameters
        int seatNo = Integer.parseInt(request.getParameter("seatNo"));
        String studName = request.getParameter("studName");
        String className = request.getParameter("className");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        // Calculate percentage and grade
        double percentage = (double) totalMarks / 100 * 100;
        String grade = calculateGrade(percentage);

        // Display student details
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Details</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + studName + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private String calculateGrade(double percentage) 
    {
        if (percentage >= 90)
         {
            return "A+";
        }
         else if (percentage >= 80)
         {
            return "A";
        }
         else if (percentage >= 70)
         {
            return "B";
        } 
        else if (percentage >= 60)
         {
            return "C";
        }
         else if (percentage >= 50)
         {
            return "D";
        }
         else 
         {
            return "Fail";
        }
    }
}
