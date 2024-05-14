package sandbox.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class SessionDemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(true);

        res.setContentType("text/html");

        var pw = res.getWriter();

        var date = (Date) hs.getAttribute("date");

        pw.print(String.format("Last access: %s", date));

        var currentDate = new Date();
        hs.setAttribute("date", currentDate);

        pw.print(String.format("Current date: %s", currentDate));

        pw.close();
    }

}
