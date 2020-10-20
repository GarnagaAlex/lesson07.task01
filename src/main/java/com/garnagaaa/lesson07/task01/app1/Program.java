package com.garnagaaa.lesson07.task01.app1;

import java.io.*;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Aleksei Garnaga
 */
public class Program {
    public static void main(String[] args) throws Exception {

        SortedSet<String> animalSet = readWordsFromFile(args[0]);
        System.out.println(animalSet.toString());
        writeFile(animalSet, args[1]);
    }

    /**
     * Метод чтения данных из файла и сортировка строк
     * @param file Исходное имя файла
     * @return Сортрованная коллекция строк
     */
    private static SortedSet<String> readWordsFromFile(String file) {
        SortedSet<String> words = new TreeSet<>();
        String line;
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.replaceAll("^ +| +$|( )+", "$1").split(" ");
                Collections.addAll(words, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * Метод записи данных в файл
     * @param data Данные для записи в файл
     * @param file Имя выходного файла
     */
    private static void writeFile(SortedSet<String> data, String file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            for (String s : data) {
                byte[] buffer = (s + "\n").getBytes();
                fileOutputStream.write(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}