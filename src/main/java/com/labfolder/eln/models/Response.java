package com.labfolder.eln.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Response {

    public Response() {
    }

    public Response(int frequency, List<String> similarWords) {
        this.frequency = frequency;
        this.similarWords = similarWords;
    }

    private int frequency = 0;
    private List<String> similarWords = new ArrayList<String>();

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void addFrequency() {
        this.frequency += 1;
    }

    @JsonProperty("similar_words")
    public List<String> getSimilarWords() {
        return similarWords;
    }

    public void setSimilarWords(List<String> similarWords) {
        this.similarWords = similarWords;
    }

    public void addSimilarWords(String similarWord) {
        this.similarWords.add(similarWord);
    }

    @Override
    public String toString() {
        return "Similar words: [" + String.join(",", this.similarWords)+"]"+ " Frequency:"+ this.frequency;
    }
}
