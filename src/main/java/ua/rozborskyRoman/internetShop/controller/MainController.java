package ua.rozborskyRoman.internetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.classes.LoggedBuyer;
import ua.rozborskyRoman.internetShop.interfaces.CheckForm;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by roman on 28.07.2016.
 */
@Controller
public class MainController {

    @Autowired
    private DAO dbManager;

    @Autowired
    private CheckForm checkForm;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registration() {
        return "main";
    }

    @RequestMapping(value = "/footwear", method = RequestMethod.GET)
    public String footwear() {
        return "footwear";
    }

    @RequestMapping(value = "/personalCabinet", method = RequestMethod.GET)
    public String personalCabinet() {
        return "personalCabinet";
    }

    @RequestMapping(value = "/checkBuyer", method = RequestMethod.POST)
    public String checkBuyer(@Valid @ModelAttribute LoggedBuyer loggedBuyer, BindingResult bindingResult) {
        if(dbManager.isExistLogin(loggedBuyer.getLogin())) {
            if(dbManager.checkPassword(loggedBuyer.getLogin(),loggedBuyer.getPassword())) {
                return "personalCabinet";
            }
        }
        bindingResult.rejectValue("login", "error.loggedBuyer", "user with this login does not exist");
        return "signIn";
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
    public ModelAndView signIn() {
        return new ModelAndView("signIn", "loggedBuyer", new LoggedBuyer()); }

    @RequestMapping(value = "/confirmSignIn", method = RequestMethod.GET)
    public String confirmSignIn() {
        return "confirmSignIn"; }

    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public ModelAndView createAccount() {
        return new ModelAndView("createAccount", "buyer", new Buyer());
    }
    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.POST)
    public String confirmRegistration(@Valid @ModelAttribute Buyer buyer, BindingResult bindingResult) {
        checkErrorsInForm(buyer, bindingResult);

        if (bindingResult.hasErrors()) {
            return "createAccount";
        }
        dbManager.addBuyer(buyer);
        return "personalCabinet";
    }


    private void checkErrorsInForm(Buyer buyer, BindingResult bindingResult) {
        if (checkForm.checkLogin(buyer.getLogin())){
            bindingResult.rejectValue("login", "error.buyer", "user with this login is already exist");
        }
        if (!checkForm.checkEqualsPasswords(buyer.getPassword(), buyer.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "error.buyer", "passwords are not equals");
        }
    }
}
