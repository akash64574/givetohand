package com.give2hand;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Give2handApplicationTests {

	@Test
	public void applicationTest() {
		Give2handApplication.main(new String[] {});
		assertTrue(true);
	}

}
