package com.app.coins.pricetype;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for parsing xml file
 */
@Component
public class ParsingUtil {

    private final static Logger Logger = LoggerFactory.getLogger(ParsingUtil.class);

    private String filePath;

    /**
     * Parse xml file and return list of dom elements contains in file
     *
     * @return list of elements
     */
    public List<Element> parseXmlResource() {
        Logger.info("Starting parsing resource from: " + filePath);
        File file = new File(filePath);
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try {
            document = builder.build(file);
        } catch (JDOMException e) {
            Logger.error("Error while xml parsing", e);
        } catch (IOException e) {
            Logger.error("Error while loading file", e);
        }

        List<Element> children;
        if (document != null) {
            children = document.getRootElement().getChildren();
        } else {
            children = new ArrayList<Element>();
        }
        return children;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
