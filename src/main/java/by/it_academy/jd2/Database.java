package by.it_academy.jd2;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private static final Map<String,Integer> artistsScore=new HashMap<>();
    private static final Map<String,Integer> genresScore=new HashMap<>();
    private static final Map<LocalDateTime, ArrayList<String>>aboutMap=new HashMap<>();

    /**
     * Метод, который возвращает поле artistsScore
     * @return - поле artistsScore
     */
    public Map<String,Integer> getArtistsScore(){
        return artistsScore;
    }

    /**
     * Метод, который возвращает поле genresScore
     * @return - поле genresScore
     */
    public Map<String,Integer> getGenresScore(){
        return genresScore;
    }

    /**
     * Метод, который возвращает поле aboutMap
     * @return - поле aboutMap
     */
    public Map<LocalDateTime, ArrayList<String>> getAboutMap(){
        return aboutMap;
    }

    /**
     * Метод, который добавляет переданные данные в поля памяти голосования
     * @param artist - имя исполнителя
     * @param genres - жанр
     * @param about - текст о себе
     */
    public static synchronized void addInfoInLists(String artist, String []genres, String about){
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

    /**
     * Метод, который возвращает рейтинг исполнителей
     * @return - рейтинг исполнителей
     */
    public static synchronized List<Map.Entry<String,Integer>> getTopArtist(){
        return artistsScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    /**
     * Метод, который возвращает рейтинг жанров
     * @return - рейтинг жанров
     */
    public static synchronized List<Map.Entry<String,Integer>> getTopGenre(){
        return genresScore.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
    }

    /**
     * Метод, который возвращает рейтинг текстов о себе
     * @return - рейтинг текстов о себе
     */
    public static synchronized List<Map.Entry<LocalDateTime,ArrayList<String>>> getTopAbout(){
        return aboutMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
    }

    /**
     * Метод, который печатает значения списка, созданного из мапы с целочиселнным значением
     * @param data - список
     * @param writer - объект Writer
     * @throws IOException
     */
    public static void writeIntValues(List<Map.Entry<String, Integer>> data, Writer writer) throws IOException {
        for (Map.Entry<String, Integer> line : data) {
            writer.write(line.getKey() + ": " + line.getValue() + "</br>");
        }
    }

    /**
     * Метод, который печатает значения списка, созданного из мапы с ключами, содержащими дату
     * @param data - список
     * @param writer - объект Writer
     * @throws IOException
     */
    public static void writeTimeValues(List<Map.Entry<LocalDateTime, ArrayList<String>>> data, Writer writer) throws IOException {
        for (Map.Entry<LocalDateTime, ArrayList<String>> line : data) {
            for (String item : line.getValue()) {
                writer.write(line.getKey().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ": "+item + "</br>");
            }
        }
    }

    /**
     * Метод, который создает разделительную строку
     * @param writer - объект Writer
     * @throws IOException
     */
    public static void writeBrakeLine(Writer writer) throws IOException {
        writer.write("****************</br>");
    }

    /**
     * Метод, который очищает данные в полях
     */
    public static synchronized void cleanData(){
        artistsScore.clear();
        genresScore.clear();
        aboutMap.clear();
    }
}
