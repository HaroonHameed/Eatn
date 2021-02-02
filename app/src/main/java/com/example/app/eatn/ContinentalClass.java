package com.example.app.eatn;


public class ContinentalClass {
    private String Itemname;
    private String Itemprice;
    private int Itemimage;
    public String Itemquantity;

    public ContinentalClass(String iName, String iPrice, int iImage,String iquantity)
    {
        Itemname = iName;
        Itemprice = iPrice;
        Itemimage = iImage;
        Itemquantity = iquantity;



    }
    public String getItemName() {
        return Itemname;
    }

    public String getItemPrice() {return Itemprice;}

    public int getImageResourceId() {return Itemimage;}

    public String getItemquantity() {return Itemquantity;}

    public void setItemquantity(String itemquantity) {
        Itemquantity = itemquantity;
    }
}

