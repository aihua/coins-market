package com.app.coins.parsing;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * TODO: Add class description
 */
@Component
public class ParsingUtils {

    public BigDecimal extractPrice() {
        return null;
    }

    public List<PriceType> parseResource() throws JDOMException, IOException {
        // TODO: implement loading resource from file system
        String filePath = "price-matrix.xml";
        File file = new File(filePath);
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(file);
        Element coinType = document.getRootElement().getChild("coinType");
        //TODO: implement it!
        return null;
    }

}
