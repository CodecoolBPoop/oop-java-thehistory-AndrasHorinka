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
        updatedList.removeAll(Arrays.asList(wordToBeRemoved));
        this.wordsArray = updatedList.toArray(new String[0]);

        // alternative method without Lists
//        int nextIndexOfSearchString = wordsArray.length;
//        int counter = 0;
//
//        while (nextIndexOfSearchString >= 0) {
//            nextIndexOfSearchString = Arrays.binarySearch(this.wordsArray, wordToBeRemoved);
//            counter++;
//            this.wordsArray[nextIndexOfSearchString] = "";
//        }
//
//        String[] updatedWords = new String[this.wordsArray.length - counter];
//        int nextIndexOfEmpty = 0;
//        int firstNullIndexInDestination = 0;
//        int lastIndexOfDestination = 0;
//        while (nextIndexOfEmpty >= 0) {
//            nextIndexOfEmpty = Arrays.binarySearch(this.wordsArray, firstNullIndexInDestination, this.wordsArray.length-1, "");
//            System.arraycopy(this.wordsArray, firstNullIndexInDestination, updatedWords, lastIndexOfDestination, nextIndexOfEmpty - firstNullIndexInDestination);
//            lastIndexOfDestination = nextIndexOfEmpty - firstNullIndexInDestination;
//            firstNullIndexInDestination = Arrays.binarySearch(updatedWords, "");
//        }
//
//        this.wordsArray = new String[updatedWords.length];
//        System.arraycopy(updatedWords, 0, this.wordsArray, 0, updatedWords.length);
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
        Arrays.sort(wordsArray);
        int nextIndex = wordsArray.length;
        while (nextIndex >= 0) {
            nextIndex = Arrays.binarySearch(this.wordsArray, from);
            this.wordsArray[nextIndex] = to;
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

//        /**
//         * Replaces all occurrences of a sentence or part of a sentence with another (part of a) sentence.
//         * The order of words are important. Also the 'fromWords' and 'toWords' arrays are not necessarily same sized.
//         * NOTE: replace() method uses this method!
//         *
//         * @param fromWords: array of words what should be replaced
//         * @param toWords:   array of words which should replace the words of 'fromWords'
//         */
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
