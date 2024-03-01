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

    public ArtistStatDto getArtistStat() {
        return artistStat;
    }

    public GenreStatDto getGenreStat() {
        return genreStat;
    }

    public AboutStatDto getAboutStat() {
        return aboutStat;
    }

    public void setArtistStat(ArtistStatDto artistStat) {
        this.artistStat = artistStat;
    }

    public void setGenreStat(GenreStatDto genreStat) {
        this.genreStat = genreStat;
    }

    public void setAboutStat(AboutStatDto aboutStat) {
        this.aboutStat = aboutStat;
    }
}

