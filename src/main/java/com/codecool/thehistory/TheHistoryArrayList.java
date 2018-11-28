package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        this.wordsArrayList.add(text);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        List<String> removeContainer = new ArrayList<>();
        removeContainer.add(wordToBeRemoved);
        wordsArrayList.removeAll(removeContainer);
    }

    @Override
    public int size() {
        return this.wordsArrayList.size();
    }

    @Override
    public void clear() {
        this.wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(this.wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        for (int i = 0; i <= size(); i++) {
            replaceOneWord(fromWords[i], toWords[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
