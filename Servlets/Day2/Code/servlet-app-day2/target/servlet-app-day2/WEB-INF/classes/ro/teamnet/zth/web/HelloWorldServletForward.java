package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.swing.text.Position.Bias.Forward;

/**
 * Created by Robert.Dumitrescu on 7/19/2017.
 */
public class HelloWorldServletForward extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloforward");

        response.getWriter().write("Hello <b>" + request.getParameter("user") + " " + " </b> from the Forward Servlet ! " + request.getAttribute("testAttribute"));
       // requestDispatcher.forward(request, response);


    }
}
