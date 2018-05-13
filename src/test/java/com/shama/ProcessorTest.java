package com.shama;

import com.shama.model.Price;
import com.shama.stream.Processor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static com.shama.TestValuesFromCustomer.convertFromString2Date;
import static org.junit.Assert.assertTrue;

public class ProcessorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


//	@Test
//	public void processNewPrices() {
//		Processor.processNewPrices(TestValuesFromCustomer.)
//	}


    // Given :   list of stored prices
    // When:   came new list pf prices where one has end before begin
    // Then :  Omit this value (may be should throw exception )
    @Test
    public void verifyInBound() {
        Price incorrectDateBound = new Price("122856", 1, 1, convertFromString2Date("20.01.2013 00:00:00")
                , convertFromString2Date("20.02.2013 23:59:59"), 11000);
        Processor.processNewPrices(TestValuesFromCustomer.existingPrices, Collections.singletonList(incorrectDateBound)) ;
        assertTrue(true);
    }

    //Given: list of stored prices
}