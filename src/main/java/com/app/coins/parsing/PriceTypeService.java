package com.app.coins.parsing;

import com.app.coins.domain.Coin;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
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
//        priceTypes = loadPriceTypes();
    }

    public BigDecimal extractPrice(Coin coin) {
        BigDecimal price = null;
        for (PriceType priceType : priceTypes) {
            if (priceType.getCountry().equalsIgnoreCase(coin.getCountry().getName())
                    && priceType.getComposition().equalsIgnoreCase(coin.getComposition().name())
                    && priceType.getYearFrom() >= coin.getYear()
                    && priceType.getYearTill() <= coin.getYear()
                    && (priceType.getGrade().equalsIgnoreCase("any") || priceType.getGrade().equalsIgnoreCase(coin.getGrade().name()))) {
                price = priceType.getPrice().multiply(calculateMultiplier(priceType.getGrade()));
            } else {
                //TODO: logging Price is not set!!!!
            }
        }
        return price;
    }

    public List<PriceType> loadPriceTypes() {
        return parsingUtils.parseResource();
    }

    public List<PriceType> getPriceTypes() {
        return priceTypes;
    }

    private BigDecimal calculateMultiplier(String grade) {
        BigDecimal multiplier;
        if (grade.equalsIgnoreCase("any")) {
            multiplier = BigDecimal.valueOf(determineCoinGrade(grade).getPriceMultiplier());
        } else {
            multiplier = BigDecimal.ONE;
        }
        return multiplier;
    }

    private Coin.Grade determineCoinGrade(String incomingGrade) {
        Coin.Grade coinGrade = null;
        for (Coin.Grade grade : Coin.Grade.values()) {
            if (grade.name().equalsIgnoreCase(incomingGrade)) {
                coinGrade = grade;
            } else {
                // TODO: logging
            }
        }
        return coinGrade;
    }
}
