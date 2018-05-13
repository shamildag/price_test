package com.shama;

import com.shama.model.Price;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for test App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
		assertArrayEquals(TestValuesFromCustomer.existingPrices.toArray(new Price[0]),
				TestValuesFromCustomer.existingPrices.toArray(new Price[0]));
	}


}
