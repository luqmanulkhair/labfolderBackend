package com.labfolder.eln.controllers;

import com.labfolder.eln.models.Request;
import com.labfolder.eln.models.Response;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class WordControllerTests {

	@Autowired
	WordController wordController;

	@Test
	public void testFindSimilarityPOST() throws JSONException {

        Request request = new Request("word word Word wor other", "word");
        Response response = wordController.findSimilarity(request);
        Assert.assertEquals(2, response.getFrequency());
        Assert.assertEquals(Arrays.asList("Word","wor"), response.getSimilarWords());

	}

    @Test
    public void testFindSimilarityGET() throws JSONException {

        Response response = wordController.findSimilarity("word word Word wor other", "word");
        Assert.assertEquals(2, response.getFrequency());
        Assert.assertEquals(Arrays.asList("Word","wor"), response.getSimilarWords());

    }

}
