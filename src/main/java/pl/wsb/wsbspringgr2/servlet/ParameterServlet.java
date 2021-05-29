package pl.wsb.wsbspringgr2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        HttpSession session = req.getSession();
        String logged = (String) session.getAttribute("logged");
        if (logged != null){
            user = logged;
        }
        Map<String, String[]> parameters = req.getParameterMap();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        if (parameters.size() != 2) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Błędne żądania, wymagane są dwa parametry.");
            return;
        }
        PrintWriter writer = resp.getWriter();
        String countStr = req.getParameter("count");
        int count = 1;
        try {
            count = Integer.parseInt(countStr);
        } catch (NumberFormatException e){
        }
        for(int i = 0; i < count; i++) {
            writer.println("Hello user: " + user);
        }
        writer.flush();
    }
}
