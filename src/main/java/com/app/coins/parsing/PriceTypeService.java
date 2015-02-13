package com.app.coins.parsing;

import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class PriceTypeService {

    private List<PriceType> priceTypes;

    @Autowired
    private ParsingUtils parsingUtils;

    public PriceTypeService() {

    }
}
