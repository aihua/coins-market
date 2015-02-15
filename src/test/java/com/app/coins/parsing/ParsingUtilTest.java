package com.app.coins.parsing;

import com.app.coins.pricetype.ParsingUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class ParsingUtilTest {

    @Autowired
    private ParsingUtil parsingUtil;

    @Test
    public void testParseResource() throws Exception {
        parsingUtil.parseXmlResource();
    }
}