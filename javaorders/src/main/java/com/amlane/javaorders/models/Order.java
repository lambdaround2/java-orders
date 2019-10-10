package com.amlane.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode",
                nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer custcode;

    public Order(double ordamount, double advanceamount, Customer custcode, String orderdescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.custcode = custcode;
    }

    public Order()
    {
        // default constructor
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription()
    {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription)
    {
        this.orderdescription = orderdescription;
    }

    public Customer getCustcode()
    {
        return custcode;
    }

    public void setCustcode(Customer custcode)
    {
        this.custcode = custcode;
    }
}
