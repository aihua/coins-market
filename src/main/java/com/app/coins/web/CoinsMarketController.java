package com.app.coins.web;

import com.app.coins.domain.Coin;
import com.app.coins.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for show coins market on UI
 */
@Controller
@RequestMapping("/")
public class CoinsMarketController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllCoins() {
        List<Coin> coins = coinService.readAll();
        ModelAndView model = new ModelAndView("index");
        model.addObject("coins", coins);

        return model;
    }
}
