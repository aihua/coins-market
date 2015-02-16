package com.app.coins.pricetype;

import com.app.coins.domain.Coin;
import org.jdom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for loading and calculating price according to price type matrix
 */
@Service
public class PriceTypeService implements PriceTypeServiceMBean {

    private final static Logger Logger = LoggerFactory.getLogger(PriceTypeService.class);

    private List<PriceType> priceTypes;

    @Autowired
    private ParsingUtil parsingUtil;

    public PriceTypeService() {
    }

    @Override
    public void refreshPriceTypeFromFile() {
        priceTypes = loadPriceTypes();
    }

    @PostConstruct
    public void initPriceTypes() {
        priceTypes = loadPriceTypes();
    }
    /**
     * Calculate price of coin according to price type matrix
     *
     * @param coin storing item
     * @return price
     */
    public BigDecimal extractPrice(Coin coin) {
        Logger.info("Starting calculating price");
        BigDecimal price = null;
        for (PriceType priceType : priceTypes) {
            if (priceType.getCountry().equalsIgnoreCase(coin.getCountry().getName())
                    && priceType.getComposition().equalsIgnoreCase(coin.getComposition().name())
                    && priceType.getYearFrom().compareTo(coin.getYear()) != 1
                    && priceType.getYearTill().compareTo(coin.getYear()) != -1
                    && (priceType.getGrade().equalsIgnoreCase("any") || priceType.getGrade().equalsIgnoreCase(coin.getGrade().name()))) {
                price = priceType.getPrice().multiply(calculateMultiplier(priceType.getGrade(), coin.getGrade()));
            }
        }

        if (price == null) {
            Logger.warn("Price can't be calculated!");
        }

        return price;
    }

    /**
     * Load price types from file
     *
     * @return list of price types from matrix
     */
    private List<PriceType> loadPriceTypes() {
        List<Element> elements = parsingUtil.parseXmlResource();

        List<PriceType> priceTypes = new ArrayList<PriceType>();
        for (Element element : elements) {
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

    /**
     * Calculate price multiplier for different grade of coins
     *
     * @param matrixGrade grade from price type matrix
     * @param coinGrade grade of storing coin
     * @return price multiplier
     */
    private BigDecimal calculateMultiplier(String matrixGrade, Coin.Grade coinGrade) {
        BigDecimal multiplier;
        if (matrixGrade.equalsIgnoreCase(Coin.Grade.ANY.name())) {
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
                coinGrade = grade;
                 break;
            }
        }
        return coinGrade;
    }
}
