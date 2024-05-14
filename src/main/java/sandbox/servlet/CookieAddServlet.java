package sandbox.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CookieAddServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        var data = req.getParameter("data");

        var cookie = new Cookie("MyCookie", data);
        res.addCookie(cookie);

        res.setContentType("text/html");

        var pw = res.getWriter();

        pw.print(String.format("%s is new %s value", data, cookie.getName()));

        pw.close();
    }

}
