package me.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow {
    RepeatCard repeatCard = new RepeatCard();
    NewCardForm newCardForm = new NewCardForm();

    protected void createMainGUI() {
        //Создаем фрейм
        JFrame mainFrame = new JFrame("Smart Card");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создаем приветственную строку
        JLabel helloStrOnMain = new JLabel("Привет, рад тебя видеть!");
        mainFrame.add(helloStrOnMain);

        //Создаем панель снизу и добавляем элементы
        JPanel mainPanel = new JPanel();

        //Создаем кнопку "Повторять" и задаем ей действие
        JButton startBtn = new JButton("Повторять");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                repeatCard.createGUI(mainFrame);
            }
        });

        //Создаем кнопку "Добавлять" и задаем ей действие
        JButton addNewBtn = new JButton("Добавлять");
        addNewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Убираем видимость окна при переходе на другое
                mainFrame.setVisible(false);
                newCardForm.createGUI(mainFrame);
            }
        });

        //Добавляем кнопки на панель
        mainPanel.add(startBtn);
        mainPanel.add(addNewBtn);

        //Добавляем компоненты на фрейм
        mainFrame.getContentPane().add(BorderLayout.PAGE_START, helloStrOnMain);
        mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        //Позволяет фрейму подбирать свой размер, для эффективного отображения элементов
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}