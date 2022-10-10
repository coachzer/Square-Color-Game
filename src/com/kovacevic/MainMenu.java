package com.kovacevic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainMenu extends JFrame{

    public MainMenu() {

        JButton newGame = new JButton("NEW GAME");
        newGame.addActionListener(new OpenListener());
        JButton quitGame = new JButton("QUIT GAME");
        quitGame.addActionListener(new CloseListener());
        JButton loadGame = new JButton("LOAD GAME");
        loadGame.addActionListener((new LoadListener()));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        panel.setLayout(new GridLayout(3, 0));
        panel.add(newGame);
        panel.add(loadGame);
        panel.add(quitGame);

        add(panel);
        setTitle("Main Menu");
        setBounds(new Rectangle(400, 400, 200, 400));
        setBackground(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class OpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Game();
            setVisible(false);
        }
    }

    private class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Game(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setVisible(false);
        }
    }

}
