package com.himank.leetcode.problems;

import java.util.*;

public class Problem36 {

    public static void main(String[] args) {
        Problem36 validateSudoku = new Problem36();
        System.out.println("Is sudoku validate? : " + validateSudoku.isValidSudoku());
    }

    public boolean isValidSudoku() {
        char[][] board = getSudoku();

        for(int i=0;i<board.length;i++) {
            if(!validateRow(board, i))
                return false;
        }

        for(int i=0;i<board[0].length;i++) {
            if(!validateColumn(board, i))
                return false;
        }

        for(int i=0;i<board.length;i+=3) {
            for(int j=0;j<board[i].length;j+=3) {
                if(!validateGrid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    char[][] getSudoku() {
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        return sudoku;
    }

    boolean validateRow(char[][] board, int row) {
        Set<Character> rowSet = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            if(board[row][i] != '.') {
                if(rowSet.contains(board[row][i]))
                    return false;
                rowSet.add(board[row][i]);
            }

        }
        return true;
    }

    boolean validateColumn(char[][] board, int column) {
        Set<Character> columnSet = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            if(board[i][column] != '.') {
                if(columnSet.contains(board[i][column]))
                    return false;
                columnSet.add(board[i][column]);
            }

        }
        return true;
    }

    boolean validateGrid(char[][] board, int startingRow, int startingCOlumn) {
        Set<Character> gridSet = new HashSet<>();
        for(int i = startingRow; i < startingRow + 3; i++) {
            for(int j = startingCOlumn; j < startingCOlumn + 3; j++) {
                if(board[i][j] != '.') {
                    if(gridSet.contains(board[i][j]))
                        return false;
                    gridSet.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
