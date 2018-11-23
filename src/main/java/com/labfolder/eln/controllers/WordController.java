package com.labfolder.eln.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.labfolder.eln.models.Request;
import com.labfolder.eln.models.Response;
import com.labfolder.eln.services.SimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
public class WordController {

    private static final Logger logger = LoggerFactory.getLogger(WordController.class);
    @Autowired
    private SimilarityService similarityService;

    @CrossOrigin
    @PostMapping("/find")
    public Response findSimilarity(@Valid @RequestBody Request request){

        logger.info("Service Request: "+ request);
        Response response = new Response();
        try {
            similarityService.getSimilarity(request, response);
        } catch (InterruptedException e) {
            logger.error("Error occured in the service"+ e);
        } catch (ExecutionException e) {
            logger.error("Error occured in the service"+ e);
        }

        logger.info("Service Response: "+ response);
        return response;
    }

    @CrossOrigin
    @GetMapping("/find")
    public Response findSimilarity(@RequestParam(value = "entry") String entry,
                                   @RequestParam(value = "keyword") String keyword){

        Request request = new Request(entry, keyword);
        logger.info("Service Request: "+ request);
        Response response = new Response();
        try {
            similarityService.getSimilarity(request, response);
        } catch (InterruptedException e) {
            logger.error("Error occured in the service"+ e);
        } catch (ExecutionException e) {
            logger.error("Error occured in the service"+ e);
        }

        logger.info("Service Response: "+ response);
        return response;
    }

    @CrossOrigin
    @GetMapping("/")
    public String findSimilarity(){
        return "LabFolder ELN API.";
    }
}
