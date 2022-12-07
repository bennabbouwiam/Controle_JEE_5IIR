package org.sid.billingservice.model;

import lombok.Data;

@Data //pour getters et setters
//il s'agit pas d'une classe jpa persistante
public class Customer {

    private Long id;
    private String name;
    private String email;
}
