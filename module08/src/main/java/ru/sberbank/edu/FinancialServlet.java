package ru.sberbank.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Hello world!
 */
@WebServlet(value = "/finance/*", loadOnStartup = 1)
public class FinancialServlet extends HttpServlet {

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String url = req.getRequestURI();

        if (url.equals("/finance") ) {
//            req.setAttribute("author", "Petr Petrov");
            setPages("/finance.jsp", req, resp);

        }

    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
//        sum: <input type="text" name="sum"/><br/>
//                percentage: <input type="text" name="percentage"/><br/>
//                years: <input type="text" name="years"/><br/>
        if (url.equals("/finance")) {
            System.out.println("***POST request: " + url);

            Integer sum = getInteger(req.getParameter("sum"));
            Integer percentage = getInteger(req.getParameter("percentage"));
            Integer years = getInteger(req.getParameter("years"));

            checkAndSetPages(req, resp, sum, percentage, years);


        }
    }

    private void checkAndSetPages(HttpServletRequest req, HttpServletResponse resp, Integer sum, Integer percentage, Integer years) throws ServletException, IOException {
        if (sum == null || percentage == null || years == null){
            String errorMessage = "Неверный формат данных. Скорректируйте значения";
            req.setAttribute("errorMessage", errorMessage);
            setPages("/error.jsp", req, resp);
        } else if (sum < 50_000) {
            String errorMessage = "Минимальная сумма на момент открытия вклада 50 000 рублей";
            req.setAttribute("errorMessage", errorMessage);
            setPages("/error.jsp", req, resp);
        } else {
            Integer count = sum * percentage * years;
            req.setAttribute("count", count);
            setPages("/count.jsp", req, resp);
        }
    }

    private void setPages(String s, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(s).forward(req, resp);
    }

    private Integer getInteger(String sum) {
        try {
            return Integer.parseInt(sum);
        }catch (NumberFormatException e) {
            return null;
        }


    }
}
