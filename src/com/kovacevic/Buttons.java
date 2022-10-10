package com.kovacevic;
import javax.swing.*;

public class Buttons extends JButton {

        private int[][] fMatrix;
        private int fX;
        private int fY;

    public int[][] getfMatrix() {
        return fMatrix;
    }

    /*public void setfMatrix(int[][] fMatrix) {
        this.fMatrix = fMatrix;
    }*/

    public int getfX() {
        return fX;
    }

    /*public void setfX(int fX) {
        this.fX = fX;
    }*/

    public int getfY() {
        return fY;
    }

    /*public void setfY(int fY) {
        this.fY = fY;
    }*/

        public Buttons(int x, int y, int[][] matrix) {
            fX = x;
            fY = y;
            fMatrix = matrix;
        }
 }

