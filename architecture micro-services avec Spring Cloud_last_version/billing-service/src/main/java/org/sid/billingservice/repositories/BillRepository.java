package org.sid.billingservice.repositories;

import org.sid.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //annotation de spring data rest (web service générique) => API Rest
public interface BillRepository extends JpaRepository<Bill,Long> {

    //pour qu'il soit accessible via rest
    @RestResource(path = "/byCustomerID")
    List<Bill> findByCustomerID(@Param("customerID") Long customerID);
}
