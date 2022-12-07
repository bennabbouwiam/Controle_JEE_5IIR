package org.sid.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;


@Projection(name = "FullBill", types = Bill.class)
public interface BillProjection {

    Long getId();
    Date getBillingDate();
    Long getCustomerID();

}
