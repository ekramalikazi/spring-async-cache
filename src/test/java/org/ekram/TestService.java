package org.ekram;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class TestService {

	@Autowired
	Service service;

	@Test
	public void testCache() {

		String response1 = service.cachedMethod1("param1", "param2");
		String response2 = service.cachedMethod1("param1", "param2");

		assertThat(response2, equalTo(response1));

		String response3 = service.cachedMethod1("param1", "param3");
		assertThat(response2, not(response3));
	}

	@Test
	public void testAsyn() {

		System.out.println("eee1");
		service.aSyncMethod(1);
		service.aSyncMethod(2);
		service.aSyncMethod(3);
		System.out.println("eee2");
		System.out.println("eee3");
		System.out.println("eee4");
	}

}
