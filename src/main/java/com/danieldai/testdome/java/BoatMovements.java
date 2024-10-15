package com.danieldai.testdome.java;

import java.util.List;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        int numOfRows = gameMatrix.length;
        int numOfColumns = gameMatrix[0].length;
        boolean validMove = true;

        if (toRow < 0 || toColumn < 0 || toRow >= numOfRows || toColumn >= numOfColumns ||
            fromRow < 0 || fromColumn < 0 || fromRow >= numOfRows || fromColumn >= numOfColumns ||
            !gameMatrix[toRow][toColumn]) {
            validMove = false;
        } else if (fromRow == toRow) {
            if(toColumn < fromColumn - 1 || toColumn > fromColumn + 2) {
                validMove = false;
            } else if (toColumn == fromColumn + 2 && !gameMatrix[toRow][fromColumn + 1]) {
                validMove = false;
            }
        } else if (Math.abs(toRow - fromRow) ==  1){
            if (toColumn != fromColumn) {
                validMove = false;
            }
        } else {
            validMove = false;
        }

        return validMove;

    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                {false, true,  true,  false, false, false},
                {true,  true,  true,  false, false, false},
                {true,  true,  true,  true,  true,  true},
                {false, true,  true,  false, true,  true},
                {false, true,  true,  true,  false, true},
                {false, false, false, false, false, false},
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}