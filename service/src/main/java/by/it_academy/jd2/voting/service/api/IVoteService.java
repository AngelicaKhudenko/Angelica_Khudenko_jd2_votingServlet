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

    /**
     * Метод, который возвращает статистику голосования по артистам
     * @return
     */
    Map <String,Integer> getArtist();

    /**
     * Метод, который возвращает статистику голосования по жанрам
     * @return
     */
    Map <String,Integer> getGenre();

    /**
     * Метод, который возвращает статистику текстов о себе
     * @return
     */
    Map<LocalDateTime, ArrayList<String>> getAbout();

}
