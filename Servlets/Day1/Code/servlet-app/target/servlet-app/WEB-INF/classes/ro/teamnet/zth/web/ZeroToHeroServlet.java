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

public class ZeroToHeroServlet extends HttpServlet {

    private String handleRequest(HttpServletRequest req) {
        String response;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        //
        response = "Hello " + firstName + " " + lastName + " Enjoy Zero To Hero!!!";

        return response;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(handleRequest(req));

    }

}
