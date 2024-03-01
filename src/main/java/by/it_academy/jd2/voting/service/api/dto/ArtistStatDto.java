package by.it_academy.jd2.voting.service.api.dto;

import java.util.List;
import java.util.Map;

public class ArtistStatDto {
    private List<Map.Entry<String,Integer>> artistScore;

    public ArtistStatDto() {
    }

    public ArtistStatDto(List<Map.Entry<String, Integer>> artistScore) {
        this.artistScore = artistScore;
    }

    public List<Map.Entry<String, Integer>> getArtistScore() {
        return artistScore;
    }

    public void setArtistScore(List<Map.Entry<String, Integer>> artistScore) {
        this.artistScore = artistScore;
    }
}
