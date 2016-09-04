package ua.rozborskyRoman.internetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborskyRoman.internetShop.classes.*;
import ua.rozborskyRoman.internetShop.classes.cart.GoodsInCartImpl;
import ua.rozborskyRoman.internetShop.classes.cart.Order;
import ua.rozborskyRoman.internetShop.interfaces.*;
import ua.rozborskyRoman.internetShop.server.Factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by roman on 28.07.2016.
 */
@Controller
public class MainController {

    @Autowired
    private DAO dbManager;

    @Autowired
    private CheckForm checkForm;

    @Autowired
    private Order order;

    @Autowired
    private RegisteredBuyer registeredBuyer;

    @Autowired
    private GoodsInCart goodsInCart;

    @Autowired
    private BuyerValidator person;

    @Autowired
    private ValuesSignIn valuesSignIn;

    @Autowired
    private Buyer buyer;

    private HttpSession httpSession;

    @ModelAttribute("registrationSignInOrName")
    public String getPerson(HttpServletRequest request){
        setSession(request);
        httpSession.setAttribute("order", order);

        try{
            RegisteredBuyer registeredBuyer = (RegisteredBuyer)httpSession.getAttribute("registeredBuyer");
            registeredBuyer.getId();
        } catch (RuntimeException exception) {
            return "<li><a href=\"/InternetShop/signIn\">SignIn</a></li>\n" +
                    "<li><a href=\"/InternetShop/createAccount\">Create account</a></li>";
        }
        return "<li><a href=\"/InternetShop/personalCabinet\">___" + registeredBuyer.getName() + "___</a></li>" +
                "<li><a href=\"/InternetShop/exit\">Exit</a></li>\"";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {

        List<GoodsCategory> goodsCategories = dbManager.takeListCategory("homeGoodsCategory");

        return new ModelAndView("main", "goodsCategories", goodsCategories);
    }


    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ModelAndView showCategories(@PathVariable("category") String category) {

        return getModelAndViewCategory(category);
    }


    @RequestMapping(value = "/{category}/{goods}", method = RequestMethod.GET)
    public String showGoods(@PathVariable("category") String category,
                            @PathVariable("goods") String goods, Model model) {

        model.addAttribute("goodsInCart", goodsInCart);

        return getModelAndViewGoods(category, goods, model);
    }


    @RequestMapping(value = "/{category}/{goods}", method = RequestMethod.POST)
    public String addGoodsToCart(@ModelAttribute GoodsInCartImpl goodsInCart,
                                        @PathVariable("category") String category,
                                        @PathVariable("goods") String goods, Model model) {

        order.addGoods(goodsInCart);

        return getModelAndViewGoods(category, goods, model);
    }


    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public ModelAndView createAccount() {

        return new ModelAndView("createAccount", "buyerValidator", person);
    }


    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.POST)
    public String confirmRegistration(@Valid @ModelAttribute(value = "buyerValidator") BuyerValidatorImpl buyerValidator,
                                      BindingResult bindingResult) {

        checkErrorsInForm(buyerValidator, bindingResult);

        if (bindingResult.hasErrors()) {
            return "createAccount";
        }

        saveBuyerInDB(buyerValidator);

        return "personalCabinet";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView signIn() {

        return new ModelAndView("signIn", "signIn", valuesSignIn);
    }


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@Valid @ModelAttribute ValuesSignInImpl valuesSignIn, BindingResult bindingResult) {

        if (isRegistered(valuesSignIn, bindingResult)){
            setParametersBuyer(valuesSignIn);

            return "redirect:/personalCabinet";
        }
        return "signIn";
    }


    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit() {

        httpSession.invalidate();

        return "redirect:/";
    }


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model) {

        model.addAttribute("order", order);
        return "cart";
    }

    @RequestMapping(value = "/removeGoods", method = RequestMethod.POST)
    public String deleteGoodsFromCart(@RequestParam(value="login") String goods) {

        order.removeGoods(goods);

        return "cart";
    }


    @RequestMapping(value = "/personalCabinet", method = RequestMethod.GET)
    public String personalCabinet() {

        return "personalCabinet";
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



    private void saveBuyerInDB(@Valid @ModelAttribute(value = "buyerValidator") BuyerValidatorImpl buyerValidator) {
        buyer.setValues(buyerValidator);
        Factory factory = Factory.getInstance();
        SaveBuyer saveBuyer = factory.getBuyer();
        saveBuyer.registerBuyer(buyer);
    }

    private void checkErrorsInForm(BuyerValidatorImpl buyer, BindingResult bindingResult) {
        if (checkForm.checkLogin(buyer.getLogin())){
            bindingResult.rejectValue("login", "error.buyer", "user with this login is already exist");
        }
        if (!checkForm.checkEqualsPasswords(buyer.getPassword(), buyer.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "error.buyer", "passwords are not equals");
        }
    }


    private void setSession(HttpServletRequest request) {
        httpSession = request.getSession(true);
        httpSession.setMaxInactiveInterval(30 * 60);
    }


    private boolean isRegistered(ValuesSignInImpl signIn, BindingResult bindingResult) {
        if(dbManager.isExistLogin(signIn.getLogin())) {
            if(dbManager.checkPassword(signIn.getLogin(),signIn.getPassword())) {
                return true;
            }
        }
        bindingResult.rejectValue("login", "error.signIn", "user with this login does not exist");

        return false;
    }


    private ModelAndView getModelAndViewCategory(String category) {
        String tableName = category + "Goods";
        List<CommonGoods> goodsList = dbManager.takeListGoods(tableName);
        String description = dbManager.takeDescription("homeGoodsCategory", category);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", category);
        modelAndView.addObject("content", goodsList);
        modelAndView.addObject("description", description);
        modelAndView.setViewName("categoryGoods");
        return modelAndView;
    }


    private String getModelAndViewGoods(String category, String goods, Model model) {

        CommonGoods resultGoods = dbManager.takeGoods(category + "Goods", goods);
        model.addAttribute("goods", resultGoods);

        return "goodsPage";
    }


    private void setParametersBuyer(ValuesSignInImpl valuesSignIn) {
        int buyerId = dbManager.getBuyerIg(valuesSignIn.getLogin());
        registeredBuyer.setId(buyerId);
        dbManager.getBuyerIg(valuesSignIn.getLogin());
        registeredBuyer.setName(dbManager.getBuyerName(buyerId));
        httpSession.setAttribute("registeredBuyer", registeredBuyer);
    }
}