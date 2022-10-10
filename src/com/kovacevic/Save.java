package com.kovacevic;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Save {

    public Save() {
        //Creating Scanner instance to read File in Java
        Scanner sc = new Scanner("save.txt");

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("save.txt"));
            out.write(Integer.toString(Game.button.length));
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }

        Scanner sc1 = new Scanner("save1.txt");

        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("save1.txt"));
            for (int i = 0; i < Game.button.length; i++) {
                for (int j = 0; j < Game.button.length; j++) {
                    out1.write(Game.button[i][j].getBackground() + " ");
                }
                out1.write("\n");
            }

            out1.flush();
            out1.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while (sc1.hasNextLine()) {
            String[] line1 = sc1.nextLine().split(" ");
            System.out.println(line1);
        }
    }
}
