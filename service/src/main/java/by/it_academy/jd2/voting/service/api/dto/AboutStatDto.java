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

    /**
     * Получение списка статистики о себе
     * @return
     */
    public List<Map.Entry<LocalDateTime, ArrayList<String>>> getAboutScore() {
        return aboutScore;
    }

    /**
     * Запись в список статистики о себе
     * @param aboutScore
     */

    public void setAboutScore(List<Map.Entry<LocalDateTime, ArrayList<String>>> aboutScore) {
        this.aboutScore = aboutScore;
    }
}
