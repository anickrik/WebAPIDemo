package com.example.webapi;

import java.io.Serializable;

public class ListItem implements Serializable {

    private String PromoCode;
    private String Title;
    private String Image;
    private String Description;
    private String ValidityStart;
    private String ValidityEnd;
    private String StoreName;
    private String CategName;






    public ListItem(String title, String description, String image, String promocode, String validityStart, String validityEnd, String categName, String storeName) {

        this.Title = title;
        this.Image = image;
        this.Description = description;
        this.PromoCode = promocode;
        this.ValidityStart = validityStart;
        this.ValidityEnd = validityEnd;
        this.CategName = categName;
        this.StoreName = storeName;

    }


    public String getPromoCode() {
        return PromoCode;
    }

    public String getValidityStart() {
        return ValidityStart;
    }

    public String getValidityEnd() {
        return ValidityEnd;
    }

    public String getStoreName() {
        return StoreName;
    }

    public String getCategName() {
        return CategName;
    }

    public String getTitle() {
        return Title;
    }

    public String getImage() {
        return Image;
    }

    public String getDescription() {
        return Description;
    }







}
