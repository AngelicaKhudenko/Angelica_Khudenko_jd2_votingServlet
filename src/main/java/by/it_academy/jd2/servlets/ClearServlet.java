package by.it_academy.jd2.servlets;

import by.it_academy.jd2.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/clear")
public class ClearServlet extends HttpServlet {
    /**
     * Метод, который очищает данные, хранящиеся в классе Database, то есть очищает статистику голосования
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database.cleanData();
    }
}