package com.codecool.thehistory;

import java.util.Arrays;
import java.util.List;

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
        List<String> updatedList = Arrays.asList(String, wordsArray);
        updatedList.removeAll(Arrays.asList("a"));
        this.wordsArray = updatedList.toArray(new String[0]);
    }

    @Override
    public int size() {
        return this.wordsArray.length;
    }

    @Override
    public void clear() {
        this.wordsArray = new String[0];
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
