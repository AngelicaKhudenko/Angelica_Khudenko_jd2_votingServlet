package by.it_academy.jd2.voting.service;

import by.it_academy.jd2.voting.dao.VoteDao;
import by.it_academy.jd2.voting.dao.api.IVoteDao;
import by.it_academy.jd2.voting.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class VoteService implements IVoteService {
    private final IVoteDao voteDao= VoteDao.getInstance();
    @Override
    public void save(String artist, String[] genres, String about) {

        if(genres==null||genres.length>5||genres.length<3){
            throw new IllegalArgumentException("Необходимо выбрать от 3 до 5 жанров");
        }

        voteDao.save(artist,genres,about);
    }

    @Override
    public void clear() {
        voteDao.clear();
    }

    @Override
    public Map<String, Integer> getArtist() {
        return this.voteDao.getArtist();
    }

    @Override
    public Map<String, Integer> getGenre() {
        return this.voteDao.getGenre();
    }

    @Override
    public Map<LocalDateTime, ArrayList<String>> getAbout() {
        return this.voteDao.getAbout();
    }
}
