package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] words = text.split(" ");
        String[] newWordsArray = new String[words.length + this.wordsArray.length];
        System.arraycopy(wordsArray, 0, newWordsArray, 0, wordsArray.length);
        System.arraycopy(words, 0, newWordsArray, this.wordsArray.length, words.length);
        this.wordsArray = new String[newWordsArray.length];
        System.arraycopy(newWordsArray, 0, this.wordsArray, 0, newWordsArray.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

        /**
         * Removes all occurrences of a word from the stored data
         *
         * @param wordToBeRemoved: only one word. No spaces just the word otherwise it won't remove anything
         */
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return 0;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
