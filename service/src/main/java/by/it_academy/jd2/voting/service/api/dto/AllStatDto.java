package by.it_academy.jd2.voting.service.api.dto;

public class AllStatDto {
    private ArtistStatDto artistStat;
    private GenreStatDto genreStat;
    private AboutStatDto aboutStat;

    public AllStatDto() {
    }

    public AllStatDto(ArtistStatDto artistStat, GenreStatDto genreStat, AboutStatDto aboutStat) {
        this.artistStat = artistStat;
        this.genreStat = genreStat;
        this.aboutStat = aboutStat;
    }

    /**
     * Получение объекта DTO по артистам
     * @return
     */
    public ArtistStatDto getArtistStat() {
        return artistStat;
    }

    /**
     * Получение объекта DTO по жанрам
     * @return
     */
    public GenreStatDto getGenreStat() {
        return genreStat;
    }

    /**
     * Получение объекта DTO по текстам о себе
     * @return
     */
    public AboutStatDto getAboutStat() {
        return aboutStat;
    }

    /**
     * Запись объекта DTO по артистам
     * @param artistStat
     */
    public void setArtistStat(ArtistStatDto artistStat) {
        this.artistStat = artistStat;
    }

    /**
     * Запись объекта DTO по жанру
     * @param genreStat
     */
    public void setGenreStat(GenreStatDto genreStat) {
        this.genreStat = genreStat;
    }

    /**
     * Запись объекта DTO по текстам о себе
     * @param aboutStat
     */
    public void setAboutStat(AboutStatDto aboutStat) {
        this.aboutStat = aboutStat;
    }
}

