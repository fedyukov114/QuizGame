package me.practice;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static me.practice.MainApp.PATH_FILE;

public abstract class AdditionalWindow {
    //Инициализируем хешмапу другой хешмапой, значения которой вернули из метода
    protected Map<Integer, String> cards = new HashMap<>();
    protected Map<Integer, String> createdCards = initMap(cards);

    //Задаем мапе значения из файла
    private Map<Integer, String> initMap(Map<Integer, String> emptyCards) {
        try {
            FileReader fr = new FileReader(PATH_FILE);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                int key = sc.nextInt();
                String value = sc.nextLine();
                emptyCards.put(key, value);
            }
            fr.close();
            System.out.println("Коллекция создана");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (emptyCards.isEmpty()) {
            System.out.println("Похоже коллекция пуста!");
        }
        return emptyCards;
    }

    //Получаем рандомную карту
    protected String getRndTopic(Map<Integer, String> cards) {
        int leftBorder = 1;
        int rightBorder = cards.size();
        int value = leftBorder + (int) (Math.random() * rightBorder);
        return cards.get(value);
    }

    //Добавляем новую карту
    protected void addNewTopic(Map<Integer, String> cards, String strFromUser) {
        Integer index = Integer.valueOf((strFromUser.substring(0, strFromUser.indexOf(" "))));
        String topic = strFromUser.substring(strFromUser.indexOf(" "));

        //Проверка на существование входящего индекса
        if (!cards.containsKey(index)) {
            try {
                FileWriter fw = new FileWriter(PATH_FILE,true);
                fw.append(strFromUser).append("\n");
                fw.close();
                cards.put(index, topic);
                System.out.println("Карта добавлена");
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("This key in file already exist!");
        }
    }

    //Изменяем карту
    protected void changeCard(Map<Integer, String> cards, String strFromUser) {
        Integer index = Integer.valueOf((strFromUser.substring(0, strFromUser.indexOf(" "))));
        String topic = strFromUser.substring(strFromUser.indexOf(" "));

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(PATH_FILE);
            fw = new FileWriter(PATH_FILE,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверка на существование входящего индекса
        if (cards.containsKey(index)) {
            cards.put(index, topic);

            String[] strArray = new String[cards.size()];
            int strArrayIndex = 0;
            Scanner sc = new Scanner(fr);

            //Заполняем строковой массив строками из файла
            while (sc.hasNextLine()) {
                strArray[strArrayIndex] = sc.nextLine();
                strArrayIndex++;
            }

            //Ищем в массиве совпадение по индексу и меняем тему на ту, которую ввел пользователь в окне ввода.
            //Затем записываем строковый массив обратно в файл
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].contains(String.valueOf(index))) {
                    strArray[i] = strFromUser;
                }
                try {
                    fw.write(strArray[i] + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new IllegalArgumentException("No such key in map!");
        }

        try {
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void createGUI(JFrame mainFrame);
}
