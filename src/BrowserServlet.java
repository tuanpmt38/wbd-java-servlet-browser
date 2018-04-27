import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BrowserServlet", urlPatterns = "/browser")
public class BrowserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        PrintWriter writer = response.getWriter();
        String browser = "Unknow browser";
        if(userAgent.contains("Firefox")){
            browser = "Mozilla Firefox";
        } else if(userAgent.contains("OPR")){
            browser = "Opera";
        } else if(userAgent.contains("Safari")) {
            if(userAgent.contains("Chrome")){
                browser = "Google Chrome";
            } else {
                browser = "Apple Safari";
            }
        }

        writer.println("<html>");
        writer.println("<h1>Browser Detector</h1>");
        writer.println("<h3>Your User-Agent Is: " + userAgent + "</h3>");
        writer.println("<h3>Your Browser Is: " + browser + "</h3>");
        writer.println("</html>");
    }
}
