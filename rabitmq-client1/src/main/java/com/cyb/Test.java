package com.cyb;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

	@Autowired
	private com.cyb.component.Runner runner;
	
	@org.junit.Test
	public void test() throws Exception {
		runner.run("操你妈逼");
	}
}
