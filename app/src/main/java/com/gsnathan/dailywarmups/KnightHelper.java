package com.gsnathan.dailywarmups;

import android.widget.TextView;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class KnightHelper {
    private int[][] myBoard;
    private int myRow;
    private int myCol;
    private int myCount;
    private static final int[] horizontal = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] vertical = {-2, -1, 1, 2, 2, 1, -1, -2};
    private TextView output;

    public KnightHelper(TextView in) {
        myBoard = new int[8][8];
        myRow = 0;
        myCol = 0;
        myCount = 1;
        myBoard[0][0] = 1;
        output = in;
    }

    public boolean canMove(int row, int col) {
        if (row < 8 && row >= 0 && col < 8 && col >= 0) {
            if (myBoard[row][col] == 0) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        int rand = (int) (Math.random() * 8);
        int newRow = myRow + horizontal[rand];
        int newCol = myCol + vertical[rand];

        while (!canMove(newRow, newCol)) {
            rand = (int) (Math.random() * 8);
            newRow = myRow - horizontal[rand];
            newCol = myCol - vertical[rand];

        }

        myRow = newRow;
        myCol = newCol;
        myCount++;
        myBoard[myRow][myCol] = myCount;

    }

    public boolean noMoreMoves() {
        for (int i = 0; i < 7; i++) {
            if (canMove(myRow + horizontal[i], myCol + vertical[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int row = 0; row < myBoard.length; row++) {
            for (int col = 0; col < myBoard[row].length; col++) {
                if (myBoard[row][col] > 9) {
                    output.append(myBoard[row][col] + "      ");
                } else {
                    output.append(myBoard[row][col] + "        ");
                }
            }
            output.append("\n");
        }
        output.append("\n" + myCount + " squares were visited");
    }


}


