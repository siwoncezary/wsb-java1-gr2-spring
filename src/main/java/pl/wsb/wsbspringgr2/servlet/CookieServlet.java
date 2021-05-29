package pl.wsb.wsbspringgr2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            Cookie colorCookie = new Cookie("color", "red");
            colorCookie.setMaxAge(100);
            resp.addCookie(colorCookie);
            return;
        }
        for(Cookie c: cookies){
            if (c.getName().equals("color")){
                String value = c.getValue();
                resp.getWriter().println("Ciastko 'color' ma wartość: " + value);
                return;
            } else {
                Cookie colorCookie = new Cookie("color", "red");
                colorCookie.setMaxAge(100);
                resp.addCookie(colorCookie);
            }
        }
    }
}
