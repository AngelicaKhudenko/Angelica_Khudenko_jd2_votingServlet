package by.it_academy.jd2.voting.controller.http;

import by.it_academy.jd2.voting.controller.http.utils.ServletUtils;
import by.it_academy.jd2.voting.service.StatService;
import by.it_academy.jd2.voting.service.api.IStatService;
import by.it_academy.jd2.voting.service.api.dto.AllStatDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/stat")
public class StatServlet extends HttpServlet {
    private IStatService statService=new StatService();
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
        PrintWriter writer=resp.getWriter();

        try {
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
