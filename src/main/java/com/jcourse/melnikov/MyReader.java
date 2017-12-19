package com.jcourse.melnikov;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BlackDox on 18.12.2017.
 */
public class MyReader {
    private Reader reader;
    private StringBuilder stringBuilder;
    private Map<String, Integer> contener;
    private MyWriter myWriter;
    private int countAllWords;

    public MyReader() throws UnsupportedEncodingException {
        reader = new InputStreamReader(new BufferedInputStream(Main.class.getClassLoader().getResourceAsStream("com.jcourse.melnikov\\texts\\text.txt")), "windows-1251");
        stringBuilder = new StringBuilder();
        contener = new HashMap<String, Integer>();
        myWriter = new MyWriter();
        countAllWords = 0;
    }

    public Map readText() throws IOException {
        System.out.println("Считывание слов...");
        while (true){
            int temp = reader.read();
            char symbol = (char) temp;
            if (temp == -1){
                this.putterToContener(symbol);
                break;
            }
            this.putterToContener(symbol);
        }

        reader.close();
        System.out.println("Неотсортированный словарик заполнен:");

        return contener;
    }

    public int getCountAllWords(){
        return countAllWords;
    }

    private void putterToContener(char symbol){
        if (Character.isLetterOrDigit(symbol)){
            stringBuilder.append(symbol);
        } else if (stringBuilder.length() >= 1) {
//                System.out.println("Слово: " + stringBuilder);
            if (contener.containsKey(String.valueOf(stringBuilder))) {
                contener.put(String.valueOf(stringBuilder), contener.get(String.valueOf(stringBuilder))+1);
            } else {
                contener.put(String.valueOf(stringBuilder), 1);
            }
            stringBuilder.setLength(0);
            countAllWords++;
        }
    }
}
