package org.example.car.rental.project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.car.rental.project.dto.CreateCarDto;
import org.example.car.rental.project.dto.UpdateCarDto;
import org.example.car.rental.project.service.CarService;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/cars/update")
public class UpdateCarServlet extends HttpServlet {

    private final CarService carService = CarService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateCarDto updateCarDto = UpdateCarDto.builder()
                .id(Long.valueOf(req.getParameter("carId")))
                .model(req.getParameter("model"))
                .brand(req.getParameter("brand"))
                .carNumber(req.getParameter("carNumber"))
                .pricePerDay(new BigDecimal(req.getParameter("pricePerDay")))
                .productionYear(Integer.valueOf(req.getParameter("productionYear")))
                .build();

        String result = carService.updateCar(updateCarDto);

        req.setAttribute("updateResult", result);
        req.getRequestDispatcher("/WEB-INF/jsp/car-update.jsp")
                .forward(req, resp);
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
