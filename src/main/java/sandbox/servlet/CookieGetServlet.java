package sandbox.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CookieGetServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var cookies = req.getCookies();

        res.setContentType("text/html");

        var pw = res.getWriter();

        for (Cookie cookie : cookies) {
            pw.println(String.format("%s: %s", cookie.getName(), cookie.getValue()));
        }

        pw.close();
    }

}
