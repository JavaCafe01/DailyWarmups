package com.gsnathan.dailywarmups;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gokul Swaminathan on 1/2/2018.
 */

public class Utils {
    private TextView output;

    public Utils(TextView view) {
        output = view;
    }

    /* Star Triangle Method */
    public void makeTri(int heightWidth) {
        String space = " ";
        String star = "*";
        int counter = 1;

        output.append("\n");
        for (int lineNum = 0; lineNum < heightWidth - 1; lineNum++) {
            output.append(star);

            if (lineNum > 1) {
                for(int x = 0; x < counter; x ++)
                output.append(space);

                counter++;
            }
            for (int c = 0; c < lineNum; c++) {
                //Recently changed
                output.append(space + space + space  + space);
            }
            if (lineNum != 0) {
                output.append(star);
            }
            output.append("\n");
        }

        for (int i = 0; i < heightWidth + 1; i++) {
            //Recently changed
            output.append(star + space + space + space);
        }
    }

    /* Star Square Method */
    public void makeSquare(int size) {
        String star = "*";
        String space = " ";

        for (int x = 0; x < size; x++) {
            for (int r = 0; r < size; r++) {
                output.append(star + space + space);
            }
            output.append("\n");
        }
    }

    /* Reverse String Method */
    public String revString(String input) {
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--)
            output += "" + input.charAt(i);

        return output;
    }

    /* Flip Halves of a string */
    public String flipHalve(String input) {
        return input.substring((int) input.length() / 2) + input.substring(0, (int) input.length() / 2);
    }

    /* Translate to Piglatin Method */
    public String transToPiglatin(String sentence) {
        String translation = PigLatinHelper.translate(sentence);
        return translation;
    }

    /* Knight Method */
    public void knightClient() {
        KnightHelper knight = new KnightHelper(output);
        while (!knight.noMoreMoves()) {
            knight.move();
        }
        knight.print();
    }

    /* Shows Toast Message */
    public static void showToast(Context context, String msg, int time) {
        CharSequence text = msg;
        int duration = time;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /* Get emoji Unicode */
    public static String getEmojiByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }
}
