package ua.rozborskyRoman.internetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rozborskyRoman.internetShop.classes.*;
import ua.rozborskyRoman.internetShop.classes.cart.GoodsInCart;
import ua.rozborskyRoman.internetShop.classes.cart.Order;
import ua.rozborskyRoman.internetShop.interfaces.CheckForm;
import ua.rozborskyRoman.internetShop.interfaces.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private HttpSession httpSession;

    @ModelAttribute()
    public void getPerson(HttpServletRequest request){
        setSession(request);
        httpSession.setAttribute("order", order);
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

        model.addAttribute("goodsInCart", new GoodsInCart());

        return getModelAndViewGoods(category, goods, model);
    }


    @RequestMapping(value = "/{category}/{goods}", method = RequestMethod.POST)
    public String addGoodsToCart(@ModelAttribute GoodsInCart goodsInCart,
                                        @PathVariable("category") String category,
                                        @PathVariable("goods") String goods, Model model) {

        order.addGoods(goodsInCart);

        return getModelAndViewGoods(category, goods, model);
    }


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


    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn() {

        return "signIn";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
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


    private void checkErrorsInForm(Buyer buyer, BindingResult bindingResult) {
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


    private ModelAndView getModelAndViewCategory(String category) {
        String tableName = category + "Goods";
        List<Goods> goodsList = dbManager.takeListGoods(tableName);
        String description = dbManager.takeDescription("homeGoodsCategory", category);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", category);
        modelAndView.addObject("content", goodsList);
        modelAndView.addObject("description", description);
        modelAndView.setViewName("categoryGoods");
        return modelAndView;
    }


    private String getModelAndViewGoods(String category, String goods, Model model) {

        Goods resultGoods = dbManager.takeGoods(category + "Goods", goods);
        model.addAttribute("goods", resultGoods);

        return "goodsPage";
    }


//    private void setParametersBuyer(ValuesSignIn valuesSignIn) {
//        int buyerId = dbManager.getBuyerIg(valuesSignIn.getLogin());
//        registeredBuyer.setId(buyerId);
//        dbManager.getBuyerIg(valuesSignIn.getLogin());
//        registeredBuyer.setName(dbManager.getBuyerName(buyerId));
//        httpSession.setAttribute("registeredBuyer", registeredBuyer);
//    }
}