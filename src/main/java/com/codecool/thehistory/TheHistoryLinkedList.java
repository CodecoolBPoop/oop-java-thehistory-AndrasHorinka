package com.codecool.thehistory;

import java.util.LinkedList;
import java.util.List;

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
        int indexOfWord = this.wordsLinkedList.indexOf(wordToBeRemoved);
        while (indexOfWord >= 0) {
            this.wordsLinkedList.remove(indexOfWord);
            indexOfWord = this.wordsLinkedList.indexOf(wordToBeRemoved);
        }
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
        for (int i = 0; i <= fromWords.length; i++) {
            replaceOneWord(fromWords[i], toWords[i]);
        }
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
