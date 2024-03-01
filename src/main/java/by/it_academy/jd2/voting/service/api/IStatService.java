package by.it_academy.jd2.voting.service.api;

import by.it_academy.jd2.voting.service.api.dto.AboutStatDto;
import by.it_academy.jd2.voting.service.api.dto.AllStatDto;
import by.it_academy.jd2.voting.service.api.dto.ArtistStatDto;
import by.it_academy.jd2.voting.service.api.dto.GenreStatDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IStatService {
    /**
     * Получение всей статистики
     * @return
     */
    AllStatDto get();

    /**
     * Получение статистики по артистам
     * @return
     */
    ArtistStatDto getArtistStat();

    /**
     * Полечение статистики по конкретному артисту
     * @param artist - артист, по которому нужно получить статистику
     * @return - количество голосов за выбранного артиста
     */
    long getByArtist(String artist);

    /**
     * Получение статистики по жанрам
     * @return
     */
    GenreStatDto getGenreStat();

    /**
     * Получение статистики по конкретному жанру
     * @param genre - жанр, по которому нужно получить статистику
     * @return - количество голосов за выбранный жанр
     */
    long getByGenre(String genre);

    /**
     * Получение всех текстов о себе
     * @return
     */
    AboutStatDto getAboutStat();

    /**
     * Получение списка текстов, зарегистрированных в указанное время
     * @param time - переданное время
     * @return
     */
    List<String> getByTime(LocalDateTime time);
}
