package sandbox.servlet;

import jakarta.servlet.*;
import java.io.IOException;

public class HelloWorldServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        var pw = res.getWriter();
        pw.println("<b>Hello, World!</b>");
        pw.close();
    }

}
