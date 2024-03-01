package by.it_academy.jd2.voting.service.api.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AboutStatDto {
    private List<Map.Entry<LocalDateTime, ArrayList<String>>> aboutScore;

    public AboutStatDto() {
    }

    public AboutStatDto(List<Map.Entry<LocalDateTime, ArrayList<String>>> aboutScore) {
        this.aboutScore = aboutScore;
    }

    public List<Map.Entry<LocalDateTime, ArrayList<String>>> getAboutScore() {
        return aboutScore;
    }

    public void setAboutScore(List<Map.Entry<LocalDateTime, ArrayList<String>>> aboutScore) {
        this.aboutScore = aboutScore;
    }
}
