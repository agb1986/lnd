package com.abg1986.lnd.accessingdatamongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Document
public class Customer {

    @Id
    private String id;
    
    private String firstName;
    private String lastName;
}
