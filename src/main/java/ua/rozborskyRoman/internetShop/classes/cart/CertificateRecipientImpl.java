package ua.rozborskyRoman.internetShop.classes.cart;

import ua.rozborskyRoman.internetShop.interfaces.CertificateRecipient;

/**
 * Created by roman on 19.08.2016.
 */
public class CertificateRecipientImpl extends GoodsInCart implements CertificateRecipient {
    private String recipientName;

    private String recipientEmail;

    private String buyerName;

    private String buyerEmail;

    private String message;

    private int amount;


    @Override
    public String getRecipientName() {
        return recipientName;
    }

    @Override
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Override
    public String getRecipientEmail() {
        return recipientEmail;
    }

    @Override
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public String getBuyerName() {
        return buyerName;
    }

    @Override
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Override
    public String getBuyerEmail() {
        return buyerEmail;
    }

    @Override
    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
