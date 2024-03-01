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

    public static AllStatDtoBuilder builder(){
        return new AllStatDtoBuilder();
    }

    public AllStatDtoBuilder setArtistStat(ArtistStatDto artistStat) {
        this.artistStat = artistStat;
        return this;
    }
    public AllStatDtoBuilder setArtistStat(List<Map.Entry<String, Integer>> score){
        this.artistStat=new ArtistStatDto(score);
        return this;
    }

    public AllStatDtoBuilder setGenreStat(GenreStatDto genreStat) {
        this.genreStat = genreStat;
        return this;
    }

    public AllStatDtoBuilder setGenreStat(List<Map.Entry<String, Integer>> score){
        this.genreStat=new GenreStatDto(score);
        return this;
    }

    public AllStatDtoBuilder setAboutStat(AboutStatDto aboutStat) {
        this.aboutStat = aboutStat;
        return this;
    }

    public AllStatDtoBuilder setAboutStat(List<Map.Entry<LocalDateTime, ArrayList<String>>> score){
        this.aboutStat=new AboutStatDto(score);
        return this;
    }

    public AllStatDto build(){
        return new AllStatDto(artistStat,genreStat,aboutStat);
    }
}
