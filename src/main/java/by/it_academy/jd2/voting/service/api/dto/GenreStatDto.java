package by.it_academy.jd2.voting.service.api.dto;

import java.util.List;
import java.util.Map;

public class GenreStatDto {
    private List<Map.Entry<String,Integer>> genreScore;

    public GenreStatDto() {
    }

    public GenreStatDto(List<Map.Entry<String, Integer>> genreScore) {
        this.genreScore = genreScore;
    }

    public List<Map.Entry<String, Integer>> getGenreScore() {
        return genreScore;
    }

    public void setGenreScore(List<Map.Entry<String, Integer>> genreScore) {
        this.genreScore = genreScore;
    }
}
