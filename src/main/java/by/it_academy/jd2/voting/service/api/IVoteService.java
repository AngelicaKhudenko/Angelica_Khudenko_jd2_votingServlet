package by.it_academy.jd2.voting.service.api;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public interface IVoteService {
    /**
     * Сохранение голоса в базу данных
     * @param artist - артист, за которого голосуют
     * @param genres - выбранные жанры
     * @param about - о себе
     */
    void save(String artist, String[] genres, String about);
    /*
    Метод, который очищает статистику голосования
     */
    void clear();
    Map <String,Integer> getArtist();
    Map <String,Integer> getGenre();
    Map<LocalDateTime, ArrayList<String>> getAbout();

}
