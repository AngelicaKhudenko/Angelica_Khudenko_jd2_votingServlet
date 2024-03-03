package by.it_academy.jd2.voting.controller.http;

import by.it_academy.jd2.voting.service.api.IClearService;
import by.it_academy.jd2.voting.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/clear")
public class ClearServlet extends HttpServlet {
    private final IClearService clearService= ServiceFactory.getClearService();
    /**
     * Метод, который очищает статистику голосования
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearService.clear();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.write("<p>"+"Данные очищены"+"</p>");
    }
}