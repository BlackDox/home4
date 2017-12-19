package com.jcourse.melnikov;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Старт программульки.");

        //читаем TXT
        MyReader myReader = new MyReader();
        Map<String, Integer> contener = myReader.readText();
        showContener(contener);

        //сортируем мапу
        Map<String, Integer> sortedContener = MySortMap.sortByValue(contener);
        showContener(sortedContener);

        //пишем в CSV
        MyWriter myWriter = new MyWriter();
        myWriter.writeToCSV(sortedContener, myReader.getCountAllWords());
    }

    private static void showContener(Map<String, Integer> contener){
        for(Map.Entry<String, Integer> entry : contener.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}