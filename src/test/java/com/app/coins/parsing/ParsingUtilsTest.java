package com.app.coins.parsing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class ParsingUtilsTest {

    @Autowired
    private ParsingUtils parsingUtils;

    @Test
    public void testParseResource() throws Exception {
//        parsingUtils = new ParsingUtils();
        List<PriceType> priceTypes = parsingUtils.parseResource();
    }
}