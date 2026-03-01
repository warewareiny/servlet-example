package org.example.car.rental.project.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.car.rental.project.dto.CreateCarDto;
import org.example.car.rental.project.exception.ValidationException;
import org.example.car.rental.project.service.CarService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/car-create")
public class AddCarServlet extends HttpServlet {

    private final CarService carService = CarService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateCarDto createCarDto = CreateCarDto.builder()
                .brand(req.getParameter("brand"))
                .carNumber(req.getParameter("carNumber"))
                .model(req.getParameter("model"))
                .pricePerDay(new BigDecimal(req.getParameter("pricePerDay")))
                .productionYear(Integer.valueOf(req.getParameter("productionYear")))
                .build();

        try {
            carService.create(createCarDto);
            resp.sendRedirect("/cars");
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/car-create.jsp")
                .forward(req, resp);
    }
}
