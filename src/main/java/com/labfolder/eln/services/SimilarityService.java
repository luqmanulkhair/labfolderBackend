package com.labfolder.eln.services;

import com.labfolder.eln.models.Request;
import com.labfolder.eln.models.Response;
import com.labfolder.eln.models.WordMap;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class SimilarityService {

    private LevenshteinDistance levenshteinDistance = LevenshteinDistance.getDefaultInstance();

    public void getSimilarity(Request request, Response response) throws InterruptedException, ExecutionException {

        String keyword = request.getKeyword();
        String[] entries = request.getEntries();

        CompletableFuture distances[] = new CompletableFuture[entries.length];

        for (int i=0; i < entries.length; i++) {
            distances[i] = findlevenstein(entries[i], keyword);
        }

        CompletableFuture.allOf(distances).join();
        for (int i=0; i < distances.length; i++) {
            CompletableFuture completableFuture = distances[i];
            WordMap wordMap = (WordMap) completableFuture.get();
            int distance = wordMap.getDistance();
            if(distance == 0){
                response.addFrequency();
            }else if(distance <= 2){
                response.addSimilarWords(wordMap.getWord());
            }
        }

    }

    @Async
    public CompletableFuture<WordMap> findlevenstein(String word, String keyword) throws InterruptedException {
        int distance = levenshteinDistance.apply(word, keyword);
        return CompletableFuture.completedFuture(new WordMap(word, distance));
    }

}
