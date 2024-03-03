package by.it_academy.jd2.voting.controller.http;

import by.it_academy.jd2.voting.controller.http.utils.ServletUtils;
import by.it_academy.jd2.voting.service.api.IStatService;
import by.it_academy.jd2.voting.service.api.IVoteService;
import by.it_academy.jd2.voting.service.api.dto.AllStatDto;
import by.it_academy.jd2.voting.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final static String ARTIST_PARAM_NAME="artist";
    private final static String GENRE_PARAM_NAME="genre";
    private final static String ABOUT_PARAM_NAME="about";

    private final IVoteService voteService= ServiceFactory.getVoteService();
    private final IStatService statService=ServiceFactory.getStatService();

    /**
     * Метод, который получает из запроса HTML данные опроса и выводит рейтинг исполнителей и жанров, и список текстов о себе
     * @param req - объект HttpServletRequest
     * @param resp - объект HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer=resp.getWriter();

        String artist=req.getParameter(ARTIST_PARAM_NAME);
        String []genres=req.getParameterValues(GENRE_PARAM_NAME);
        String about=req.getParameter(ABOUT_PARAM_NAME);

        try {
            this.voteService.save(artist,genres,about);
            AllStatDto allStatDto=this.statService.get();

            writer.write("<p>Статистика голосования за лучшего исполнителя</p>");
            ServletUtils.writeBrakeLine(writer);
            ServletUtils.writeIntValues(allStatDto.getArtistStat().getArtistScore(), writer);
            ServletUtils.writeBrakeLine(writer);
            ServletUtils.writeIntValues(allStatDto.getGenreStat().getGenreScore(), writer);
            ServletUtils.writeBrakeLine(writer);
            ServletUtils.writeTimeValues(allStatDto.getAboutStat().getAboutScore(), writer);
        } catch (IllegalArgumentException e){
            writer.write("<p>"+e.getMessage()+"</p>");
        }
    }
}
