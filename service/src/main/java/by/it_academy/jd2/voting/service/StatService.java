package by.it_academy.jd2.voting.service;

import by.it_academy.jd2.voting.service.api.IStatService;
import by.it_academy.jd2.voting.service.api.IVoteService;
import by.it_academy.jd2.voting.service.api.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatService implements IStatService {
    private final IVoteService voteService;

    public StatService(IVoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public AllStatDto get() {
        return AllStatDtoBuilder.builder()
                .setArtistStat(getArtistStat())
                .setGenreStat(getGenreStat())
                .setAboutStat(getAboutStat())
                .build();
    }

    @Override
    public ArtistStatDto getArtistStat() {
        return new ArtistStatDto(getTopWithInt(voteService.getArtist()));
    }

    @Override
    public long getByArtist(String artist) {
        return voteService.getArtist().getOrDefault(artist,0);
    }

    @Override
    public GenreStatDto getGenreStat() {
        return new GenreStatDto(getTopWithInt(voteService.getGenre()));
    }

    @Override
    public long getByGenre(String genre) {
        return voteService.getGenre().getOrDefault(genre,0);
    }

    @Override
    public AboutStatDto getAboutStat() {
        return new AboutStatDto(getTopAbout(voteService.getAbout()));
    }

    @Override
    public List<String> getByTime(LocalDateTime time) {
        return voteService.getAbout().getOrDefault(time,null);
    }

    /**
     * Метод, который возвращает отсортированный список, сформированный из мапы
     * @param data - мапа для сортировки
     * @return
     */
    private List<Map.Entry<String,Integer>> getTopWithInt(Map<String,Integer> data){
        return data.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

    }

    /**
     * Метод, который возвращает рейтинг текстов о себе
     * @return - рейтинг текстов о себе
     */
    private List<Map.Entry<LocalDateTime, ArrayList<String>>> getTopAbout(Map<LocalDateTime,ArrayList<String>> data){
        return data.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());
    }
}
