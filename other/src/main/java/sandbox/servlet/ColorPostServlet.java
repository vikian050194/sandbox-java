package sandbox.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ColorPostServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var color = req.getParameter("color");

        res.setContentType("text/html");

        var pw = res.getWriter();

        pw.print(String.format("%s is selected", color));

        pw.close();
    }

}
