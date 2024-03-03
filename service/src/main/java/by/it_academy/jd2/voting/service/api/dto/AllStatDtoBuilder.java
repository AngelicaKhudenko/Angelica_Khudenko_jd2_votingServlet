package by.it_academy.jd2.voting.service.api.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllStatDtoBuilder {
    private ArtistStatDto artistStat;
    private GenreStatDto genreStat;
    private AboutStatDto aboutStat;

    private AllStatDtoBuilder() {
    }

    /**
     * Возвращает объект класса AllStatDtoBuilder
     * @return
     */
    public static AllStatDtoBuilder builder(){
        return new AllStatDtoBuilder();
    }

    /**
     * Запись данных статистики об артистах
     * @param artistStat - объект ArtistStatDto
     * @return
     */
    public AllStatDtoBuilder setArtistStat(ArtistStatDto artistStat) {
        this.artistStat = artistStat;
        return this;
    }

    /**
     * Запись данных статистики об артистах
     * @param score - статистика об артистах
     * @return
     */
    public AllStatDtoBuilder setArtistStat(List<Map.Entry<String, Integer>> score){
        this.artistStat=new ArtistStatDto(score);
        return this;
    }

    /**
     * Запись данных статистики о жанрах
     * @param genreStat - объект DTO GenreStatDto
     * @return
     */
    public AllStatDtoBuilder setGenreStat(GenreStatDto genreStat) {
        this.genreStat = genreStat;
        return this;
    }

    /**
     * Запись данных статистики о жанрах
     * @param score - статистика о жанрах
     * @return
     */
    public AllStatDtoBuilder setGenreStat(List<Map.Entry<String, Integer>> score){
        this.genreStat=new GenreStatDto(score);
        return this;
    }

    /**
     * Запись данных статистики о себе
     * @param aboutStat - объект DTO AboutStatDto
     * @return
     */
    public AllStatDtoBuilder setAboutStat(AboutStatDto aboutStat) {
        this.aboutStat = aboutStat;
        return this;
    }

    /**
     * Запись данных статистики о себе
     * @param score - статистика о себе
     * @return
     */
    public AllStatDtoBuilder setAboutStat(List<Map.Entry<LocalDateTime, ArrayList<String>>> score){
        this.aboutStat=new AboutStatDto(score);
        return this;
    }

    /**
     * Метод, возвразающий объект класса AllStatDto
     * @return
     */
    public AllStatDto build(){
        return new AllStatDto(artistStat,genreStat,aboutStat);
    }
}
