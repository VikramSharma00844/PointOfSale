/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TANISH SHARMA
 */
public class Bill {
    int billid;
    String datetime;
    int gtotal;
    String adminemail;
    String phoneno;
    String paymenttype;

    public Bill(int billid, String datetime, int gtotal, String adminemail, String phoneno, String paymenttype) {
        this.billid = billid;
        this.datetime = datetime;
        this.gtotal = gtotal;
        this.adminemail = adminemail;
        this.phoneno = phoneno;
        this.paymenttype = paymenttype;
    }

    
}
