package ua.rozborskyRoman.internetShop.interfaces;

/**
 * Created by roman on 18.08.2016.
 */
public interface CertificateRecipient {

    String getRecipientName();

     void setRecipientName(String recipientName);

    String getRecipientEmail();

    void setRecipientEmail(String recipientEmail);

    String getBuyerName();

    void setBuyerName(String buyerName);

    String getBuyerEmail();

    void setBuyerEmail(String buyerEmail);

    String getMessage();

    void setMessage(String message);

    int getAmount();

    void setAmount(int amount);
}
