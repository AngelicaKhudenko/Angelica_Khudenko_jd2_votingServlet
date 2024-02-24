package by.it_academy.jd2.servlets;

import by.it_academy.jd2.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/stat")
public class CheckServlet extends HttpServlet {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    /**
     * Метод, который выводит рейтинг исполнителей и жанров, и список текстов о себе
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Map.Entry<String, Integer>> topArtist = Database.getTopArtist();
        List<Map.Entry<String, Integer>> topGenre = Database.getTopGenre();
        List<Map.Entry<LocalDateTime, ArrayList<String>>> topAbout = Database.getTopAbout();

        PrintWriter writer=resp.getWriter();

        writer.write("<p>Статистика голосования за лучшего исполнителя</p>");
        Database.writeBrakeLine(writer);
        Database.writeIntValues(topArtist, writer);
        Database.writeBrakeLine(writer);
        Database.writeIntValues(topGenre, writer);
        Database.writeBrakeLine(writer);
        Database.writeTimeValues(topAbout, writer);
    }
}
