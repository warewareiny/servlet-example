package org.example.car.rental.project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.car.rental.project.service.CarService;

import java.io.IOException;

@WebServlet("/cars/info")
public class CarInformationServlet extends HttpServlet {

    private final CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String carIdParam = req.getParameter("carId");

        if (carIdParam == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing carId parameter");
            return;
        }

        try {
            Long carId = Long.valueOf(carIdParam);

            var carOptional = carService.findById(carId);
            if (carOptional.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Car not found");
                return;
            }

            req.setAttribute("car", carOptional.get());
            req.getRequestDispatcher("/WEB-INF/jsp/car-info.jsp")
                    .forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid carId format");
        }
    }
}