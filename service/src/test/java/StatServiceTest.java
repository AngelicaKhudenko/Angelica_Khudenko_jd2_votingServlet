import by.it_academy.jd2.voting.service.api.IStatService;
import by.it_academy.jd2.voting.service.api.IVoteService;
import by.it_academy.jd2.voting.service.api.dto.AllStatDto;
import by.it_academy.jd2.voting.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatServiceTest {
    @Test
    public void testOnArtist(){
        IStatService statService = ServiceFactory.getStatService();

        AllStatDto allStatDto = statService.get();

        int maxScore = -1;
        for (Map.Entry<String, Integer> entry : allStatDto.getArtistStat().getArtistScore()) {
            if(maxScore == -1){
                maxScore = entry.getValue();
            } else {
                if(maxScore >= entry.getValue()){
                    maxScore = entry.getValue();
                } else {
                    Assertions.fail("Статистика вернулась не в правильном порядке");
                }
            }
        }
    }

    @Test
    public void testOnGenre(){
        IStatService statService = ServiceFactory.getStatService();

        AllStatDto allStatDto = statService.get();

        int maxScore = -1;
        for (Map.Entry<String, Integer> entry : allStatDto.getGenreStat().getGenreScore()) {
            if(maxScore == -1){
                maxScore = entry.getValue();
            } else {
                if(maxScore >= entry.getValue()){
                    maxScore = entry.getValue();
                } else {
                    Assertions.fail("Статистика вернулась не в правильном порядке");
                }
            }
        }
    }

    @Test
    public void testOnAbout(){
        IStatService statService = ServiceFactory.getStatService();

        AllStatDto allStatDto = statService.get();

        LocalDateTime time=LocalDateTime.now();
        for (Map.Entry<LocalDateTime, ArrayList<String>> entry : allStatDto.getAboutStat().getAboutScore()) {
            if (time.isAfter(entry.getKey())){
                time=entry.getKey();
            } else {
                Assertions.fail("Статистика вернулась не в правильном порядке");
            }
        }
    }

    public static class TestVoteService implements IVoteService {
        private LocalDateTime time1;
        private LocalDateTime time2;
        private LocalDateTime time3;
        private LocalDateTime time4;
        @Override
        public void save(String artist, String[] genres, String about) {
        }

        @Override
        public void clear() {
        }

        @Override
        public Map<String, Integer> getArtist() {
            return new HashMap<>(){{
                put("Валерий Меладзе", 3);
                put("Григорий Лепс", 10000000);
                put("Imagine Dragons", 99);
                put("Dabro", 2);
            }};
        }

        @Override
        public Map<String, Integer> getGenre() {
            return new HashMap<>(){{
                put("рок", 3);
                put("поп", 1000);
                put("хип-хоп", 99);
                put("классика", 10);
            }};
        }

        @Override
        public Map<LocalDateTime, ArrayList<String>> getAbout() {
            time1=LocalDateTime.now();
            ArrayList <String> list1=new ArrayList<>();
            list1.add("Весеннее настроение");
            time2=LocalDateTime.now();
            ArrayList <String> list2=new ArrayList<>();
            list2.add("Меломен");
            time3=LocalDateTime.now();
            ArrayList <String> list3=new ArrayList<>();
            list3.add("Меланхолия");
            time4=LocalDateTime.now();
            ArrayList <String> list4=new ArrayList<>();
            list4.add("Funny");

            return new HashMap<>(){{
                put(time1, list1);
                put(time2, list2);
                put(time3, list3);
                put(time4, list4);
            }};
        }
    }
}

