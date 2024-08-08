/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Cart {
    String productname;
    String catname;
    int quantity;
    int offerprice;
    int perTotal;
    
    public Cart(String productname,String catname, int quantity,int offerprice,int perTotal){
        this.productname = productname;
        this.catname = catname;
        this.quantity = quantity;
        this.offerprice = offerprice;
        this.perTotal = perTotal;
    }
}
