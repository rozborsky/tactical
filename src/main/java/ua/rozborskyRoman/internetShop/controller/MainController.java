package ua.rozborskyRoman.internetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

/**
 * Created by roman on 28.07.2016.
 */
@Controller
public class MainController {

    @Autowired
    private DAO dbManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registration() {

        return "main";
    }

    @RequestMapping(value = "/footwear", method = RequestMethod.GET)
    public String footwear() {
        return "footwear";
    }

    @RequestMapping(value = "/clothing", method = RequestMethod.GET)
    public String clothing() {
        return "clothing";
    }

    @RequestMapping(value = "/gear", method = RequestMethod.GET)
    public String gear() {
        return "gear";
    }

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public String deals() { return "deals"; }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public String brands() { return "brands"; }

    @RequestMapping(value = "/getSertificates", method = RequestMethod.GET)
    public String getSertificates() { return "getSertificates"; }

    @RequestMapping(value = "/myAccount", method = RequestMethod.GET)
    public String myAccount() { return "myAccount"; }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn() { return "signIn"; }

    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public ModelAndView createAccount() {
        return new ModelAndView("createAccount", "buyer", new Buyer());
    }
    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.POST)
    public String confirmRegistration(Buyer buyer) {
        dbManager.addBuyer(buyer);
        return "confirmRegistration";
    }
}