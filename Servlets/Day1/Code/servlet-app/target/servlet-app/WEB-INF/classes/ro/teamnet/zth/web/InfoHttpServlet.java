package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Robert.Dumitrescu on 7/18/2017.
 */
@WebServlet(name = "InfoHttpServlet")
public class InfoHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(firstName);
        printWriter.write(lastName);
        printWriter.write(age);
        printWriter.write(request.getMethod());
        printWriter.write(String.valueOf(request.getCookies()));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
