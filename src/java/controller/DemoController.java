package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DemoController", urlPatterns = {"/first"})
public class DemoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Client gửi request đến doGet
        String firstValueRaw = request.getParameter("firstvalue");
        String secondValueRaw = request.getParameter("secondvalue");
        String phepTinh = request.getParameter("pheptinh");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int firstValue = Integer.parseInt(firstValueRaw);
            int secondValue = Integer.parseInt(secondValueRaw);
            int res;
            if("cong".equals(phepTinh)){
                res = firstValue + secondValue;
                out.println("Result: " + firstValue + "+" + secondValue + "=" + res );
            }
            else if("tru".equals(phepTinh)){
                res = firstValue - secondValue;
                out.println("Result: " + firstValue + "-" + secondValue + "=" + res );
            }
            else{
                out.println("Invalid operation");
            }
        } catch (Exception e) {
            out.println("Please enter valid number!!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
