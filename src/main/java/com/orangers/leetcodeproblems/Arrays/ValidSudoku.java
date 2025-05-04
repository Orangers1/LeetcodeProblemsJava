package com.orangers.leetcodeproblems.Arrays;

import java.util.HashSet;

/**
 * problem can be found at: <a href="https://neetcode.io/problems/valid-sudoku"> problem link </a>
 */
public class ValidSudoku {
    /**
     * * problem can be found at: <a href="https://neetcode.io/problems/valid-sudoku"> neetcode </a> <br>
     * Checks if a given sudoku board is valid - is valid if follows the following rules:
     *  <li>Each row must contain the digits 1-9 without duplicates. </li>
     *  <li> Each column must contain the digits 1-9 without duplicates. </li>
     *  <li> Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates. </li>
     *  <li> Note: a board does not need to be full or solvable to be valid. </li>
     * @param board - the sudoku board (9x9 board)
     * @return whether the board is valid or not
     */
    public boolean isValidSudoku(char[][] board) {
        // use set to track digits already seen
        HashSet<Character> seenDigits = new HashSet<>();
        // check for if each row contains digits 1-9 without duplicates
        for (char[] chars : board) {
            seenDigits.clear();
            for (char aChar : chars) {
                if (seenDigits.contains(aChar)) {
                    return false;
                } else {
                    if (aChar != '.') { // ignore empty spaces for this check
                        seenDigits.add(aChar);
                    }
                }
            }
        }

        // same code as above but swap the accesses for board to use j,i instead of i,j to effectively go by columns first
        for (int i = 0; i < board.length; i++) {
            seenDigits.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (seenDigits.contains(board[j][i])) {
                    return false;
                } else{
                    if(board[j][i] != '.') {
                        seenDigits.add(board[j][i]);
                    }
                }
            }
        }

        // if here then columns and rows are valid, now just check the 9 3x3 sub-boxes.
        for (int i = 0 ; i < 3; i++) { // loop through 3 rows of sub-boxes
            for (int j = 0; j < 3; j++) { // loop through 3 columns of sub-boxes
                seenDigits.clear();
                for(int k = 0; k < 3; k++) { // loop through rows of sub-box
                    for (int l = 0; l < 3; l++) { // loop through columns of sub-box
                        if (seenDigits.contains(board[k+ i*3][l + j*3])) {
                            return false;
                        } else{
                            if(board[k + i*3][l + j*3] != '.') {
                                seenDigits.add(board[k+ i*3][l + j*3]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}