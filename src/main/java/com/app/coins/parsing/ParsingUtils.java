package com.app.coins.parsing;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Add class description
 */
@Component
public class ParsingUtils {

    public List<PriceType> parseResource() {
        // TODO: implement loading resource from file system
        String filePath = "src\\main\\resources\\price-matrix.xml";
        File file = new File(filePath);
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try {
            document = builder.build(file);
        } catch (JDOMException e) {
            e.printStackTrace(); //TODO: logging
        } catch (IOException e) {
            e.printStackTrace(); //TODO: logging
        }
        List<Element> children = document.getRootElement().getChildren();
        List<PriceType> priceTypes = new ArrayList<PriceType>();
        for (Element element : children) {
            PriceType priceType = new PriceType();
            priceType.setCountry(element.getChild("country").getText());
            priceType.setComposition(element.getChild("composition").getText());
            priceType.setYearFrom(Integer.valueOf(element.getChild("yearFrom").getText()));
            priceType.setYearTill(Integer.valueOf(element.getChild("yearTill").getText()));
            priceType.setGrade(element.getChild("grade").getText());
            priceType.setPrice(new BigDecimal(element.getChild("price").getText()));
            priceTypes.add(priceType);
        }

        return priceTypes;
    }

}
