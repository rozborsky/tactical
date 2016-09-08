package ua.rozborskyRoman.internetShop.classes.model;

import ua.rozborskyRoman.internetShop.classes.goods.GoodsCategoriesManagerHibernate;
import ua.rozborskyRoman.internetShop.classes.goods.GoodsCategory;
import ua.rozborskyRoman.internetShop.interfaces.GoodsCategoriesManager;

/**
 * Created by roman on 08.09.2016.
 */
public class CreateAndInitDB {

    public void setCategories() {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setName("eyewear");
        goodsCategory.setDescription("When you are out in the field, you need protection you can count on for your whole body, and your eyes are no exception. Ballistic eyewear ensures that your eyes are kept safe from small fragments and projectiles, things that you can easily come up against while you’re on a mission. They are especially recommended for anyone who is shooting or may potentially be shot at.\n" +
                "\n" +
                "Tactical glasses like these come in a variety of styles and colors. Many people opt for the sunglasses, giving them maximum protection from the sun’s glare as well. There are other varieties that offer anti-fog capabilities. Which is the best option for you will depend on the situation in which you will be using them.\n" +
                "\n" +
                "The bottom line is, in order to do your job properly, you need to be able to see well. Your eyes need protecting from the elements and all the extra bits that may come your way. With all the hard work that you have put into your career, you want to do everything you can to make sure that you are abl");
        goodsCategory.setImage("eyewear");

        GoodsCategory goodsCategory1 = new GoodsCategory();
        goodsCategory1.setName("uniforms");
        goodsCategory1.setDescription("Military Uniforms are essential in every branch of the United States Military, so order the right apparel that will assist you in the line of duty. We have a vast selection of clothing available, and various patterns can be found that will match well with your official issue military uniform.  \n" +
                "\n" +
                "When you are working, you need to right clothes to grant you a full range of motion so you can accomplish the task at hand without feeling restrained in the slightest. Even if you are not in the military, there is some great apparel to be found.\n" +
                "\n" +
                "The right clothing can make all the difference, so get some of the best around by ordering top-quality military uniforms. Virtually anything you could ever hope for is here, so browse through our selection to see what works best for you. Everyone has something to gain, so order the ideal uniform today.\n" +
                "\n" +
                "For comprehensive information on AR 670-1 uniform regulations, visit Army Uniform Changes.\n" +
                "\n" +
                "For more information on how to properly roll your s");
        goodsCategory1.setImage("uniforms");

        GoodsCategory goodsCategory2 = new GoodsCategory();
        goodsCategory2.setName("weaponAccessories");
        goodsCategory2.setDescription("A tactical operative without a capable weapon is as good as naked in the field. Even the highest-quality firearms require support and maintenance in order to deliver peak performance. When you gear up with proven weapon accessories, you feel the confidence that comes with poise and preparation. Whether you’re in need of responsive lights, holsters, slings, or cases for your firearms, you’ll find all of the top tactical brands right here every day.\n" +
                "\n" +
                "Outfit your firearm for maximum performance in any environment with implements by the best brands on the market. Improve your protection, grip, and aim with innovative add-ons and achieve balance and fight fatigue with capable slings. Finally, assure yourself of a fluid and consistent draw when you equip one of the various holsters we offer. To keep barrels and moving parts squeaky clean, utilize quality cleaning products.\n" +
                "\n" +
                "Once your firearms are cleaned and fully outfitted, keep them safe with high-performance carriers and cases. Our ca");
        goodsCategory2.setImage("weaponAccessories");

        GoodsCategory goodsCategory3 = new GoodsCategory();
        goodsCategory3.setName("boots");
        goodsCategory3.setDescription("You’ve known what an important piece of the uniform tactical boots are from the day you enlisted. \u00ADIn training, you went on grueling marches, stood in formation during heat and rain, and tackled tough obstacle courses. Every day during that life-changing experience you relied on your boots to provide you with support and keep your feet protected so you could successfully finish boot camp a tougher, stronger, better service member. You found out just how important the right pair of military boots can be.\n" +
                "\n" +
                "Now that you are looking for tactical boots for your career, you know that you need to choose a pair that keeps you on the path to being a better service member. You don’t want your boots to be a reason that you aren’t in the best shape. Whether this is one of your first pairs of military boots or this is one of a long history of pairs that have served you well while you were serving your country, we want to make your purchase as easy as possible.\n" +
                "\n" +
                "Finding the right pair of militar");
        goodsCategory3.setImage("boots");


        GoodsCategoriesManager hibernate = new GoodsCategoriesManagerHibernate();
        hibernate.addCategory(goodsCategory);
        hibernate.addCategory(goodsCategory1);
        hibernate.addCategory(goodsCategory2);
        hibernate.addCategory(goodsCategory3);
    }
}
