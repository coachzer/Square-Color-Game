package com.kovacevic;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonsAction implements ActionListener {

    private Buttons source; // First Button
    private Buttons target; // Second Button
    private int clicked = 0;
    private int counter1;
    private int counter2;

    @Override
    public void actionPerformed(ActionEvent e) {

        /*Nothing is selected on the startup, so the first button we select will be our source button.*/
        if (source == null) {
            source = (Buttons) e.getSource();
            clicked++;
            source.setText("S");
            source.setFont(new Font("Courier New", Font.BOLD, 25));
            // System.out.println("Source x: [" + source.getfX() + "] and y: [" + source.getfY() + "]");
        }
        /*The second button we select is our target button.*/
        else {
            target = (Buttons) e.getSource();
            clicked++;
            if (theNeighbourhood()) {
                source.setText("");
                switchColors(target, target.getBackground(), source.getBackground());
            }
            source.setText("");
            source = null;
            // System.out.println("Target x: [" + target.getfX() + "] and y: [" + target.getfY() + "]");

            if (winCondition()) {
                JFrame frame = new JFrame("WINNER FRAME");
                JPanel panel = new JPanel();
                JLabel label1 = new JLabel(" - YOU ARE VICTORIOUS");
                JLabel label2 = new JLabel("NUMBER OF CLICKS: " + clicked);
                panel.setLayout(new GridBagLayout());    /* Places components in a grid of rows and columns,
                                                     allowing specified components to span multiple rows or columns.*/
                panel.add(label2);
                panel.add(label1);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10 ));
                frame.add(panel);
                frame.setSize(350, 100);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            if (possibleContinuation()) {
                System.out.println("Continuation is possible, blue is still on the field.");
            }
            else {
                System.out.println("YOU LOST");
            }
        }

        System.out.println("Number of clicks: " + clicked);
    }

    private boolean theNeighbourhood() {

        return Math.abs(target.getfY() - source.getfY()) == 1 && target.getfX() == source.getfX() ||
                Math.abs(target.getfX() - source.getfX()) == 1 && target.getfY() == source.getfY();
    }

    private boolean switchColorsConfirmed() {

        return ((target.getfX() >= 0 && target.getfX() <= Game.button.length) ||
                (target.getfY() >= 0 && target.getfX() <= Game.button.length));

    }

    private void switchColors(Buttons button, Color targetColor, Color replacementColor) {

        if (targetColor == replacementColor) {
            return;
        }
        else if (button.getBackground() != targetColor) {
            return;
        }
        else {
            button.setBackground(replacementColor);
            if (switchColorsConfirmed()) {
                if (button.getfX() + 1 < Game.button.length) {
                    switchColors(Game.button[button.getfX() + 1][button.getfY()], targetColor, replacementColor);
                }
                if (button.getfX() - 1 >= 0) {
                    switchColors(Game.button[button.getfX() - 1][button.getfY()], targetColor, replacementColor);
                }
                if (button.getfY() + 1 < Game.button.length) {
                    switchColors(Game.button[button.getfX()][button.getfY() + 1], targetColor, replacementColor);
                }
                if (button.getfY() - 1 >= 0) {
                    switchColors(Game.button[button.getfX()][button.getfY() - 1], targetColor, replacementColor);
                }
            }
        }
    }

    private boolean winCondition() {

        counter1 = 0;
        for (int i = 0; i < Game.button.length; i++) {
            for (int j = 0; j < Game.button.length; j++) {
                if (Game.button[i][j].getBackground().equals(new Color(32, 100, 232))) {
                    counter1++;
                }
            }
        }
        int x = Game.button.length * Game.button.length;
        if (counter1 == x) {
            return true;
        }
        else if (counter1 == 0) {
            return false;
        }
        else return false;
    }

    private boolean possibleContinuation() {

        counter2 = 0;
        for (int i = 0; i < Game.button.length; i++) {
            for (int j = 0; j < Game.button.length; j++) {
                if (Game.button[i][j].getBackground().equals(new Color(32, 100, 232))) {
                    counter2++;
                }
            }
        }
        int c = Game.button.length * Game.button.length;
        if (counter2 != 0) {
            return true;
        }
        else if (counter2 == c) {
            return false;
        }
        else return false;
    }
}
