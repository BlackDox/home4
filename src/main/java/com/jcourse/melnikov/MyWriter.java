package com.jcourse.melnikov;

import java.io.*;
import java.util.Map;

/**
 * Created by BlackDox on 18.12.2017.
 */
public class MyWriter {

    public void writeToCSV(Map<String, Integer> contener, int countAllWords) {
        System.out.println("Начат процесс записи в CSV...");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testCsv.csv"), "cp1251"))) {
            writer.write("Слово;Частота;Частота(%)"+"\n");

            for(Map.Entry<String, Integer> entry : contener.entrySet()){
                Double frequency = Math.rint((Double.valueOf(entry.getValue()) * 100 / countAllWords)*1000) / 1000;
                writer.write(entry.getKey() + ";" + entry.getValue() + ";" + frequency +";\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Процесс записи в CSV...завершен!");
    }
}
