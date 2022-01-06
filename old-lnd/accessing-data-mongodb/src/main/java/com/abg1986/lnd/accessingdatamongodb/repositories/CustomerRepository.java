package com.abg1986.lnd.accessingdatamongodb.repositories;

import java.util.List;
import com.abg1986.lnd.accessingdatamongodb.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    <S extends Customer> S save(S entity);
}
