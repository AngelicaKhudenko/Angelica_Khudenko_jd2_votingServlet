package by.it_academy.jd2.voting.controller.http.utils;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServletUtils {
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
}
