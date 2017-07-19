package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Robert.Dumitrescu on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "";
        String pass = "";
        Cookie[] cookies = req.getCookies();
        user = req.getParameter("username");
        pass = req.getParameter("password");
        Object id = null;
        if (user.equals("admin") && pass.equals("admin")) {
            resp.getWriter().write("Welcome back " + user + "!");
            for (Cookie c : cookies){
                resp.getWriter().write("Cookie :"+ c.getName()+" value:"+c.getValue());
            }
           //  id = req.getSession().getId();
        }
        else {
            req.getSession().setAttribute("username",user);
            req.getSession().setAttribute("session",req.getSession());
            resp.sendRedirect("/servlet-app-day2/views/loginFail.jsp");
        }
    }
}
