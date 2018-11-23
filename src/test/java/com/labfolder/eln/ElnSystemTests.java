package com.labfolder.eln;

import com.labfolder.eln.controllers.WordController;
import com.labfolder.eln.models.Request;
import com.labfolder.eln.models.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ElnSystemTests {

	@Autowired
	WordController wordController;

	@Test
	public void testFindPOST() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();

        JSONObject request = new JSONObject();
        request.put("entry", "word Word Word word");
        request.put("keyword", "word");

        int frequncy = 2;
        String similarWords[] = {"Word", "Word"};

        String url = "http://localhost:8080/findSimilarity";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println("Respnse Bod"+ response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONObject responseJson = new JSONObject(response.getBody());
        Assert.assertEquals(responseJson.get("frequency"), frequncy);
        Assert.assertEquals(responseJson.get("similar_words"), new JSONArray(similarWords));

	}

    @Test
    public void testFindGET() throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("entry", "word Word Word word");
        params.put("keyword", "word");

        int frequncy = 2;
        String similarWords[] = {"Word", "Word"};

        String url = "http://localhost:8080/findSimilarity?entry={entry}&&keyword={keyword}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, entity, String.class, params);

        System.out.println("Respnse Bod"+ response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONObject responseJson = new JSONObject(response.getBody());
        Assert.assertEquals(responseJson.get("frequency"), frequncy);
        Assert.assertEquals(responseJson.get("similar_words"), new JSONArray(similarWords));

    }


    @Test
    public void testFindSpace() throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("entry", "word Word  Word    word");
        params.put("keyword", "    word    ");

        int frequncy = 2;
        String similarWords[] = {"Word", "Word"};

        String url = "http://localhost:8080/findSimilarity?entry={entry}&&keyword={keyword}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, entity, String.class, params);

        System.out.println("Respnse Bod"+ response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONObject responseJson = new JSONObject(response.getBody());
        Assert.assertEquals(responseJson.get("frequency"), frequncy);
        Assert.assertEquals(responseJson.get("similar_words"), new JSONArray(similarWords));

    }


}
