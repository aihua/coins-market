package com.app.coins.web;

import com.app.coins.domain.Country;
import com.app.coins.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO: Add comment
 */
@Controller
@RequestMapping("/")
public class CoinsMarketController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET)
    public String start(ModelMap model) {
        Country country = countryService.read("UK");
        model.addAttribute("message", country.getFullName());

        return "index";
    }
}
