package com.labfolder.eln.models;

public class WordMap {

    String word;
    int distance = 0;

    public WordMap() {
    }

    public WordMap(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
