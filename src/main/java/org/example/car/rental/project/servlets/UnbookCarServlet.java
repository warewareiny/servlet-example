package org.example.car.rental.project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.car.rental.project.service.CarService;

import java.io.IOException;

@WebServlet("/cars/unbook")
public class UnbookCarServlet extends HttpServlet {

    private final CarService carService = CarService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long carId = Long.valueOf(req.getParameter("carId"));
        String result = carService.unbookCar(carId);

        req.setAttribute("unbookResult", result);
        req.getRequestDispatcher("/WEB-INF/jsp/unbook-result.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/unbook-result.jsp")
                .forward(req, resp);
    }
}
