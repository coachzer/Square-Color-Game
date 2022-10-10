package com.kovacevic;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Game {

    public static Buttons button[][];
    public static JFrame frame;
    public static JPanel panel;

    Random rnd = new Random();

    public static int n;
    public static int m;

    public Game() {

        n = rnd.nextInt(12) + 4;
        m = n;

        int matrix[][] = new int[n][m];

        frame = new JFrame("Game Window");
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        panel.setLayout(new GridLayout(n, m));

        Colors color = new Colors();
        ButtonsAction b = new ButtonsAction();
        button = new Buttons[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                button[i][j] = new Buttons(i, j, matrix);
                button[i][j].addActionListener(b);
                button[i][j].setPreferredSize(new Dimension(55, 55));
                button[i][j].setBackground(color.rotation());
                panel.add(button[i][j]);
            }
        }

        frame.add(panel);
        frame.pack(); // Packs the components closely together
        frame.setVisible(true); // Set the frame visible
        frame.setResizable(false); // Frame cannot be resizable
        frame.setLocationRelativeTo(null); // Center the frame on start
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X closes the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new Save();
            }
        });
    }

    public Game(boolean load) throws IOException {

        BufferedReader firstReader = new BufferedReader(new FileReader("save.txt"));
        Scanner firstScanner = new Scanner(firstReader);
        List list = new ArrayList<>();
        while (firstScanner.hasNext()) {
            if (firstScanner.hasNextInt()) {
                list.add(firstScanner.nextInt());
            } else {
                firstScanner.next();
            }
        }
        System.out.println(list);
        n = (int)list.get(0);
        m = n;

        int matrix[][] = new int[n][m];

        frame = new JFrame("Game Window");
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        panel.setLayout(new GridLayout(n, m));

        ButtonsAction b = new ButtonsAction();
        button = new Buttons[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                button[i][j] = new Buttons(i, j, matrix);
                button[i][j].setPreferredSize(new Dimension(55, 55));
            }
        }

        BufferedReader secondReader = new BufferedReader(new FileReader("save1.txt"));
        Scanner secondScanner = new Scanner(secondReader);

        int i = 0, j = 0;
        while (secondScanner.hasNext()) {
            String k = secondScanner.nextLine();
            String[] l = k.split(" ");
            /*Comparing strings and assigning colors so we can resume where we left off*/
            for (String o : l) {
                if (o.equals("java.awt.Color[r=232,g=229,b=229]")) {
                    button[i][j].setBackground(new Color(232, 229, 229));
                }
                else if (o.equals("java.awt.Color[r=191,g=79,b=79]")) {
                    button[i][j].setBackground(new Color(191, 79, 79));
                }
                else if (o.equals("java.awt.Color[r=135,g=160,b=103]")) {
                    button[i][j].setBackground(new Color(135, 160, 103));
                }
                else if (o.equals("java.awt.Color[r=242,g=230,b=63]")) {
                    button[i][j].setBackground(new Color(242, 230, 63));
                }
                else if (o.equals("java.awt.Color[r=32,g=100,b=232]")) {
                    button[i][j].setBackground(new Color(32, 100, 232));
                }
                j++;
            }
            i++;
            j = 0;
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                button[i][j].addActionListener(b);
                panel.add(button[i][j]);
            }
        }

        frame.add(panel);
        frame.pack(); // Packs the components closely together
        frame.setVisible(true); // Set the frame visible
        frame.setResizable(false); // Frame cannot be resizable
        frame.setLocationRelativeTo(null); // Center the frame on start
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X closes the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                new Save();
            }
        });
    }

}
