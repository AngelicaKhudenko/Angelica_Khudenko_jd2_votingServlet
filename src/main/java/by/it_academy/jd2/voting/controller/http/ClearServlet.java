package by.it_academy.jd2.voting.controller.http;

import by.it_academy.jd2.voting.service.ClearService;
import by.it_academy.jd2.voting.service.api.IClearService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/clear")
public class ClearServlet extends HttpServlet {
    private final IClearService clearService=new ClearService();
    /**
     * Метод, который очищает данные, хранящиеся в классе Database, то есть очищает статистику голосования
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearService.clear();
    }
}