package com.codecool.thehistory;

import java.util.*;

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
//        System.out.println();
        String[] splitToWords = this.wordsArrayList.get(0).split("\\s+");

//        System.out.println("Inside ArrayList -- FROM: " + from + " -- TO: " + to);
        for (int i=0; i < splitToWords.length; i++) {

//            System.out.println("for iteration started............iteration: " + i);
//            System.out.println("splitwords[i]............" + splitToWords[i]);

            if (splitToWords[i].equals(from)) {
//                System.out.println("from: " + splitToWords[i]);
                splitToWords[i] = to;
//                System.out.println("to: " + splitToWords[i]);
            }
//            System.out.println("**************************************");
        }
//        ------------------------------------------------------------------------
//        Collections.replaceAll(this.wordsArrayList, from, to);
//        ------------------------------------------------------------------------
/*        ListIterator<String> iterator = wordsArrayList.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next element: " + next);
            if (next.equals(from)) {
                iterator.set(to);
                System.out.println("replaced to: " + iterator);
            }
        }*/
//        ------------------------------------------------------------------------
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
                /*
        Issue statement: the from is a pair of words ("replace me") --> thus having spaces. Yet wordsArrayList is split by spaces, thus it will never match.
        Possible solution is to --> have the word as 1 word --> and if it found in the wordsArray -- check if the next word is the same as the next element, etc.
        Iterate as many times as long the fromWords is
         */
//        System.out.println("-----------FROM WORDS ----------");
//        System.out.println();
//
//        for (String word : fromWords) {
//            System.out.print(word + ", ");
//        }
//        System.out.println();
//        System.out.println("-----------TO WORDS ----------");
//        System.out.println();

//        for (String word : toWords) {
//            System.out.print(word + ", ");
//        }

        String[] splitToWords = this.wordsArrayList.get(0).split("\\s+");
//        System.out.println();
//        System.out.println("fromWords length:............" + fromWords.length);
//        System.out.println("History length:............" + splitToWords.length);

        for (int i = 0; i < splitToWords.length-fromWords.length - 1; i++) {
//            System.out.println();
//            System.out.println("for iteration started............iteration: " + i);
//            System.out.println(splitToWords[i] + " ::: must be equal to ::: " + fromWords[0]);

            if (splitToWords[i].equals(fromWords[0])) {
                if (allFurtherMatch(splitToWords, i, fromWords)) {
//                    System.out.println("!!!!!!!!!!!!ALL FURTHER ENTRY MATCH !!!!!!!!");
                    for (int k = 0; k < fromWords.length; k++) {
//                        System.out.println("splitwords[i+k], where i == " + i + " and k == " + k + "  results in: " + splitToWords[i+k]);
                        splitToWords[i+k] = toWords[k];
//                        System.out.println("updated splitwords[i+k] results in: " + splitToWords[i+k]);
                    }
                }
            }
        }

        this.wordsArrayList = new ArrayList<>();
        List<String> words =  new ArrayList<>(Arrays.asList(splitToWords));
        this.wordsArrayList.addAll(words);
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

//    private String stringifyArray(String[] stringArray) {
//        StringBuilder sb = new StringBuilder();
//        for (String word : stringArray) {
//            sb.append(word);
//            sb.append("\t");
//        }
//        return sb.toString().trim();
//    }

    private boolean allFurtherMatch(String[] history, int bigIndex, String[] replaceList) {
//        System.out.println("allFurthermatch initiated. Length of replaceList:::: " + replaceList.length);
        int trueCounter = 0;
        for (int j = 1; j < replaceList.length; j++) {
//            System.out.println("All Further Iteration............... iteration index: " + j);
//            System.out.println(replaceList[j] + ":::: must be equal to ::::" + history[bigIndex + j]);
            if (replaceList[j].equals(history[bigIndex + j])) {
//                System.out.println("~~~ They were found matching ~~~");
                trueCounter = trueCounter + 1;
            }
        }

        if (trueCounter == replaceList.length - 1) {
            return true;
        }
        return false;
    }
}
