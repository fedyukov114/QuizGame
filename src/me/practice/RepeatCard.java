package me.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepeatCard extends AdditionalWindow {
    @Override
    protected void createGUI(JFrame mainFrame) {
        JFrame frameOnRepeatCard = new JFrame("Smart Card");
        frameOnRepeatCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel strOnRepeatCard = new JLabel("Начинаем повторять");

        JPanel panelOnRepeatCard = new JPanel();
        JButton nextCardBtn = new JButton("Еще 1 карточку");
        nextCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strOnRepeatCard.setText("Тема: " + getRndTopic(createdCards));
            }
        });
        JButton turnBackBtn = new JButton("Вернуться");
        turnBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameOnRepeatCard.setVisible(false);
                mainFrame.setVisible(true);
            }
        });
        panelOnRepeatCard.add(nextCardBtn);
        panelOnRepeatCard.add(turnBackBtn);

        frameOnRepeatCard.getContentPane().add(BorderLayout.PAGE_START, strOnRepeatCard);
        frameOnRepeatCard.getContentPane().add(BorderLayout.CENTER, panelOnRepeatCard);
        frameOnRepeatCard.pack();
        frameOnRepeatCard.setVisible(true);
    }
}
