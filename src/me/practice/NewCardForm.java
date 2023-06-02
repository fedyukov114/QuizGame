package me.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCardForm extends AdditionalWindow {
    @Override
    protected void createGUI(JFrame mainFrame) {
        JFrame frameOnNewCard = new JFrame("Smart Card");
        frameOnNewCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel strOnNewCard = new JLabel("Приветствую в форме редактирования!");
        JTextField userInputPanel = new JTextField(35);
        JPanel panelOnNewCard = new JPanel();

        JButton turnBackBtn = new JButton("Вернуться");
        turnBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameOnNewCard.setVisible(false);
                mainFrame.setVisible(true);
            }
        });

        JButton addNewCard = new JButton("Добавить карту");
        addNewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTopic(createdCards, userInputPanel.getText());
                userInputPanel.setText("Карта добавлена");
            }
        });

        JButton changeCard = new JButton("Изменить карту");
        changeCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(createdCards, userInputPanel.getText());
            }
        });

        JButton deleteCard = new JButton("Удалить карту");
        deleteCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCard(createdCards, userInputPanel.getText());
            }
        });

        panelOnNewCard.add(turnBackBtn);
        panelOnNewCard.add(addNewCard);
        panelOnNewCard.add(changeCard);
        panelOnNewCard.add(deleteCard);

        frameOnNewCard.getContentPane().add(BorderLayout.PAGE_START, strOnNewCard);
        frameOnNewCard.getContentPane().add(BorderLayout.CENTER, userInputPanel);
        frameOnNewCard.getContentPane().add(BorderLayout.PAGE_END, panelOnNewCard);
        frameOnNewCard.pack();
        frameOnNewCard.setVisible(true);
    }
}