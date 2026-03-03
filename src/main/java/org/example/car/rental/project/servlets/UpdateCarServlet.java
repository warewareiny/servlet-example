package org.example.car.rental.project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.car.rental.project.dto.UpdateCarDto;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.service.CarService;

import java.io.IOException;

@WebServlet("/cars/update")
public class UpdateCarServlet extends HttpServlet {

    private final CarService carService = CarService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UpdateCarDto updateCarDto = UpdateCarDto.builder()
                .id(Long.valueOf(req.getParameter("carId")))
                .model(req.getParameter("model"))
                .brand(req.getParameter("brand"))
                .carNumber(req.getParameter("carNumber"))
                .pricePerDay(req.getParameter("pricePerDay"))
                .productionYear(req.getParameter("productionYear"))
                .build();

        try {
            String result = carService.updateCar(updateCarDto);
            req.setAttribute("updateResult", result);

        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            req.setAttribute("car", updateCarDto);
        }

        resp.sendRedirect(req.getContextPath() + "/cars/info?carId=" + updateCarDto.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("carId"));

        carService.findById(id).ifPresent(car ->
                req.setAttribute("car", car)
        );

        req.getRequestDispatcher("/WEB-INF/jsp/car-update.jsp")
                .forward(req, resp);
    }
}
