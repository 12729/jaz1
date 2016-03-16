package lukasz;

/**
 * Created by LouL on 16.03.2016.
 */

import lukasz.Data;
import lukasz.Item;
import lukasz.Calculator;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/harmonogram")
public class Servlet extends HttpServlet {

    Calculator creditCalculationService = new Calculator();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Data creditData = RequestMapper.mapToCreditData(req);
        if(creditData == null) {
            req.setAttribute("error", true);
            req.getRequestDispatcher(Resources.IndexJsp).forward(req, resp);
            return;
        }
        List<Item> items = Calculator.calculate(tData);
        forwardPaymentsSchedule(req, resp, Items);
    }

    private void forwardPaymentsSchedule(HttpServletRequest req, HttpServletResponse resp, List paymentsScheduleItems)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Resources.PaymentsScheduleJsp);
        req.setAttribute("paymentsScheduleList", Items);
        dispatcher.forward(req, resp);
    }
