package by.it_academy.jd2.voting.dao;

import by.it_academy.jd2.voting.dao.api.IVoteDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VoteDao implements IVoteDao {
    private final Map<String,Integer> artistsScore;
    private final Map<String,Integer> genresScore;
    private final Map<LocalDateTime, ArrayList<String>> aboutMap;
    public VoteDao() {
        artistsScore=new HashMap<>();
        genresScore=new HashMap<>();
        aboutMap=new HashMap<>();
    }

    public VoteDao(Map<String, Integer> artistsScore, Map<String, Integer> genresScore, Map<LocalDateTime, ArrayList<String>> aboutMap) {
        this.artistsScore = artistsScore;
        this.genresScore = genresScore;
        this.aboutMap = aboutMap;
    }

    @Override
    public synchronized void save(String artist, String[] genres, String about) {
        artistsScore.compute(artist,(k,v)->v!=null?v+1:1);
        for (String genre:genres){
            genresScore.compute(genre, (k,v)->v!=null?v+1:1);
        }

        LocalDateTime time=LocalDateTime.now();
        ArrayList<String> textList=aboutMap.get(time);
        if (textList==null){
            textList=new ArrayList<>();
        }
        textList.add(about);
        aboutMap.put(time,textList);
    }

    @Override
    public void clear() {
        artistsScore.clear();
        genresScore.clear();
        aboutMap.clear();
    }

    @Override
    public Map<String, Integer> getArtist() {
        return Collections.unmodifiableMap(this.artistsScore);
    }

    @Override
    public Map<String, Integer> getGenre() {
        return Collections.unmodifiableMap(this.genresScore);
    }

    @Override
    public Map<LocalDateTime, ArrayList<String>> getAbout() {
        return Collections.unmodifiableMap(this.aboutMap);
    }
}
