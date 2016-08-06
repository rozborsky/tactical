package ua.rozborskyRoman.internetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborskyRoman.internetShop.classes.Buyer;
import ua.rozborskyRoman.internetShop.classes.GoodsCategory;
import ua.rozborskyRoman.internetShop.classes.LoggedBuyer;
import ua.rozborskyRoman.internetShop.classes.cart.Order;
import ua.rozborskyRoman.internetShop.interfaces.CheckForm;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by roman on 28.07.2016.
 */
@Controller
@SessionAttributes("httpSession")
public class MainController {

    @Autowired
    private DAO dbManager;

    @Autowired
    private CheckForm checkForm;

    @Autowired
    private Order order;

    private HttpSession httpSession;

    private String buyer = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request) {
        httpSession = request.getSession(true);
        return getModelAndView("main", "homePageGoodsList");
    }

    @RequestMapping(value = "/footwear", method = RequestMethod.GET)
    public ModelAndView footwear() {
        return getModelAndView("footwear", "footwearPageGoodsList");
    }

    @RequestMapping(value = "/footwear/jump", method = RequestMethod.GET) //temporary
    public ModelAndView footwearJump() {
        return getModelAndView("jump", "footwearPageGoodsList");
    }

    @RequestMapping(value = "/personalCabinet", method = RequestMethod.GET)
    public String personalCabinet() {
        return "personalCabinet";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@Valid @ModelAttribute LoggedBuyer loggedBuyer, BindingResult bindingResult) {
        if (isRegistered(loggedBuyer, bindingResult)){
            return "personalCabinet";
        }
        return "signIn";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView signIn() {
        return new ModelAndView("signIn", "loggedBuyer", new LoggedBuyer()); }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cart() {
        return new ModelAndView("cart", "loggedBuyer", new LoggedBuyer()); }

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

    private ModelAndView getModelAndView(String page, String table) {
        List<GoodsCategory> goodsCategories = dbManager.takeListGoods(table);
        ModelAndView modelAndView = new ModelAndView(page, "goodsCategories", goodsCategories);
        String registrationSignInOrName;
        if(buyer != null){
            registrationSignInOrName = "<li><a href=\"personalCabinet\">" + buyer + "</a></li>";
        }else{
            registrationSignInOrName = "<li><a href=\"signIn\">SignIn</a></li>\n" +
                    "<li><a href=\"createAccount\">Create account</a></li>";
        }
        httpSession.setAttribute("totalPrise", order.totalPrise());
        httpSession.setAttribute("registrationSignInOrName", registrationSignInOrName);

        return modelAndView;
    }

    private boolean isRegistered(LoggedBuyer loggedBuyer, BindingResult bindingResult) {
        if(dbManager.isExistLogin(loggedBuyer.getLogin())) {
            if(dbManager.checkPassword(loggedBuyer.getLogin(),loggedBuyer.getPassword())) {
                buyer = "nameBuyer";
                return true;
            }
        }
        bindingResult.rejectValue("login", "error.loggedBuyer", "user with this login does not exist");
        return false;
    }
}
