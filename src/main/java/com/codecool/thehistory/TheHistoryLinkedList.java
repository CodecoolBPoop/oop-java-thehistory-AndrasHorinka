package com.codecool.thehistory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        this.wordsLinkedList.add(text);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public int size() {
        return this.wordsLinkedList.size();
    }

    @Override
    public void clear() {
        this.wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        int indexOfWord = this.wordsLinkedList.indexOf(to);
        while (indexOfWord >= 0) {
            this.wordsLinkedList.set(indexOfWord, to);
            indexOfWord = this.wordsLinkedList.indexOf(to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
