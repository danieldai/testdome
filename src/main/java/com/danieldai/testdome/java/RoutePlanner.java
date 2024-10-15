package com.danieldai.testdome.java;

import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        int numOfRows = mapMatrix.length;
        int numOfColumns = mapMatrix[0].length;

        if (fromRow < 0 || fromRow >= numOfRows || fromColumn < 0 || fromColumn >= numOfColumns ||
                toRow < 0 || toRow >= numOfRows || toColumn < 0 || toColumn >= numOfColumns ||
                !mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false;
        }

        if(fromRow == toRow && fromColumn == toColumn) {
            return true;
        }

        boolean result = false;
        boolean tmp = mapMatrix[fromRow][fromColumn];
        mapMatrix[fromRow][fromColumn] = false;
        result = routeExists(fromRow + 1, fromColumn, toRow, toColumn, mapMatrix) ||
                routeExists(fromRow - 1, fromColumn, toRow, toColumn, mapMatrix) ||
                routeExists(fromRow, fromColumn + 1, toRow, toColumn, mapMatrix) ||
                routeExists(fromRow, fromColumn - 1, toRow, toColumn, mapMatrix);
        mapMatrix[fromRow][fromColumn] = tmp;

        return result;

    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
