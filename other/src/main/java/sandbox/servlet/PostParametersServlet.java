package sandbox.servlet;

import jakarta.servlet.*;
import java.io.IOException;

public class PostParametersServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        var pw = res.getWriter();

        var e = req.getParameterNames();
        while (e.hasMoreElements()) {
            var pname = e.nextElement();
            pw.print(pname + " = ");
            var pvalue = req.getParameter(pname);
            pw.write(pvalue);
        }

        pw.close();
    }

}
