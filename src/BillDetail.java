/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class BillDetail {
    int billdetailid ;
    int billid;
    String pname;
    int offerprice;
    int quantity;

    public BillDetail(int billdetailid, int billid, String pname, int offerprice, int quantity) {
        this.billdetailid = billdetailid;
        this.billid = billid;
        this.pname = pname;
        this.offerprice = offerprice;
        this.quantity = quantity;
    }
    
}
