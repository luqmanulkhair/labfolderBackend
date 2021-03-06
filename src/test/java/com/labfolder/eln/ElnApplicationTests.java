package com.labfolder.eln;

import com.labfolder.eln.controllers.WordController;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ElnApplicationTests {

	@Autowired
	WordController wordController;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(wordController);
	}

}
