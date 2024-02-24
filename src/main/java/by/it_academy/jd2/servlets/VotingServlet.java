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

@WebServlet (urlPatterns = "/vote")
public class VotingServlet extends HttpServlet {
    private final static String ARTIST_PARAM_NAME="artist";
    private final static String GENRE_PARAM_NAME="genre";
    private final static String ABOUT_PARAM_NAME="about";

    /**
     * Метод, который получает из запроса HTML данные опроса и выводит рейтинг исполнителей и жанров, и список текстов о себе
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String artist=req.getParameter(ARTIST_PARAM_NAME);
        String []genres=req.getParameterValues(GENRE_PARAM_NAME);
        String about=req.getParameter(ABOUT_PARAM_NAME);

        PrintWriter writer=resp.getWriter();

        if (genres.length<3||genres.length>5){
            writer.write("<p>"+"Вы ввели неверное количество жанров. Пожалуйста, выберите от 3 до 5 вариантов"+"</p>");
        } else {
            Database.addInfoInLists(artist, genres, about);

            List<Map.Entry<String, Integer>> topArtist = Database.getTopArtist();
            List<Map.Entry<String, Integer>> topGenre = Database.getTopGenre();
            List<Map.Entry<LocalDateTime, ArrayList<String>>> topAbout = Database.getTopAbout();

            writer.write("<p>Статистика голосования за лучшего исполнителя</p>");
            Database.writeBrakeLine(writer);
            Database.writeIntValues(topArtist, writer);
            Database.writeBrakeLine(writer);
            Database.writeIntValues(topGenre, writer);
            Database.writeBrakeLine(writer);
            Database.writeTimeValues(topAbout, writer);
        }
    }
}
