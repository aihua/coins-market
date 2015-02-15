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
public class PriceTypeService implements PriceTypeServiceMBean {

    private List<PriceType> priceTypes;

    @Autowired
    private ParsingUtils parsingUtils;

    public PriceTypeService() {
    }

    @Override
    public void refreshPriceTypeFromFile() {
        priceTypes = loadPriceTypes();
    }

    public BigDecimal extractPrice(Coin coin) {
        priceTypes = loadPriceTypes();
        BigDecimal price = null;
        for (PriceType priceType : priceTypes) {
            if (priceType.getCountry().equalsIgnoreCase(coin.getCountry().getName())
                    && priceType.getComposition().equalsIgnoreCase(coin.getComposition().name())
                    && priceType.getYearFrom().compareTo(coin.getYear()) != 1
                    && priceType.getYearTill().compareTo(coin.getYear()) != -1
                    && (priceType.getGrade().equalsIgnoreCase("any") || priceType.getGrade().equalsIgnoreCase(coin.getGrade().name()))) {
                price = priceType.getPrice().multiply(calculateMultiplier(priceType.getGrade(), coin.getGrade()));
            } else {
                //TODO: logging Price is not set!!!!
            }
        }
        return price;
    }

    public List<PriceType> loadPriceTypes() {
        return parsingUtils.parseResource();
    }

    private BigDecimal calculateMultiplier(String matrixGrade, Coin.Grade coinGrade) {
        BigDecimal multiplier;
        if (matrixGrade.equalsIgnoreCase("any")) {
            multiplier = BigDecimal.valueOf(determineCoinGrade(coinGrade).getPriceMultiplier());
        } else {
            multiplier = BigDecimal.ONE;
        }
        return multiplier;
    }

    private Coin.Grade determineCoinGrade(Coin.Grade incomingGrade) {
        Coin.Grade coinGrade = null;
        for (Coin.Grade grade : Coin.Grade.values()) {
            if (grade.equals(incomingGrade)) {
                coinGrade = grade; //TODO add break
            } else {
                // TODO: logging
            }
        }
        return coinGrade;
    }

    public List<PriceType> getPriceTypes() {
        return priceTypes;
    }
}
