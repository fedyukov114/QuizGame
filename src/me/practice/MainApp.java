package me.practice;

import javax.swing.*;

public class MainApp {
    public static final String PATH_FILE = System.getenv("FILEPATH");

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mw.createMainGUI();
            }
        });
    }
}