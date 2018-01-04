package com.gsnathan.dailywarmups;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class PigLatinHelper {

    public PigLatinHelper() {
    }


    /*
     * Translates the given sentence into Pig Latin.
     */
    public static String translate(String sentence) {
        // The translation of the given sentence will be incrementally
        // appended to this string
        String translatedSentence = "";

        // The current word to translate, built up as we loop through the
        // input sentence.
        String currentWord = "";

        // Loop through each character in the input sentence to build up words
        // which will then be translated and added to the translated sentence.
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            // If we are looking at a character that should be included in a
            // word, add it to the current word. This takes punctuation inside
            // of words (e.g. "can't") into account.
            if (isWordChar(c, i, sentence)) {
                currentWord += c;
            }

            // We have encountered a non-word-letter, so we need to translate
            // the current word and append it to the translated sentence.
            else {
                // We only translate the current word if it is non-empty,
                // which helps preserve successive punctuation/spacing (e.g. a
                // comma followed by a space)
                if (!currentWord.equals("")) {
                    translatedSentence += translateWord(currentWord);
                    currentWord = "";
                }

                // Add the current character to the translated sentence. This
                // preserves punctuation and spacing.
                translatedSentence += c;
            }
        }

        // If we've reached the end of the sentence and we still have a current
        // word, we have one word left to translate. This happens if the given
        // sentence does not end in punctuation or a space.
        if (!currentWord.equals("")) {
            translatedSentence += translateWord(currentWord);
        }

        return translatedSentence;
    }


    /*
     * Translates the given word into Pig Latin.
     */
    private static String translateWord(String word) {
        // Find the first vowel in the given word. Pig Latin translation
        // changes depending on where (if at all) the first vowel occurs in a
        // word.
        int firstVowel = findFirstVowel(word);

        // If the given word starts with a vowel or contains no vowels, we
        // just append "yay" to the word.
        if (firstVowel == 0 || firstVowel == -1) {
            return word + "yay";
        }

        // Otherwise, split the word at the first vowel, swap the halves and
        // append "ay"
        else {
            return word.substring(firstVowel) +
                    word.substring(0, firstVowel) +
                    "ay";
        }
    }


    /*
     * Find and return the position of the first vowel in the given word. If no
     * vowels are found, returns -1. Y is always treated as a consonant.
     */
    private static int findFirstVowel(String word) {
        // Loop through each character of the given word
        for (int i = 0; i < word.length(); i++) {
            // Use the lower case of the given character to make comparisons
            // easier
            char c = word.toLowerCase().charAt(i);

            // If the current character is a vowel, return the current index.
            if ("aeiou".indexOf(c) != -1) {
                return i;
            }
        }

        // No vowels were found, so return -1.
        return -1;
    }


    /*
     * Determines whether the given character, at the given position in the
     * given sentence, should be treated as part of a word. Returns true if the
     * character is a letter or if it is a digit or punctuation mark surrounded
     * by letters (which takes care of contractions, e.g. "can't")
     */
    private static boolean isWordChar(char c, int position, String sentence) {
        // If we're looking at a letter, return true
        if (Character.isLetter(c)) {
            return true;
        }

        // If we're looking at digit or a punctuation mark, check to see if it
        // is surrounded by letters. If so, return true.
        else if (String.valueOf(c).matches("[\\d\\p{Punct}]")) {
            // We only do this check if the given character is not the first or
            // last in the sentence.
            if (position > 0 && position < sentence.length() - 1) {
                return Character.isLetter(sentence.charAt(position - 1)) &&
                        Character.isLetter(sentence.charAt(position + 1));
            }
        }

        // Must not be a "word character."
        return false;
    }
}