    package org.example.car.rental.project.servlets;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.example.car.rental.project.service.CarService;

    import java.io.IOException;

    @WebServlet("/cars/fix")
    public class FixCarServlet extends HttpServlet {

        private final CarService carService = CarService.getInstance();

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long carId = Long.valueOf(req.getParameter("carId"));
            String successFix = carService.fixCar(carId);

            req.setAttribute("successFix", successFix);
            req.getRequestDispatcher("/WEB-INF/jsp/fix-result.jsp")
                    .forward(req, resp);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/jsp/fix-result.jsp")
                    .forward(req, resp);
        }
    }
