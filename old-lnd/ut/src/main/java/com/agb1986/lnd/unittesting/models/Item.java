package com.agb1986.lnd.unittesting.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Item {
    
    @Id
    @NonNull
    private Integer id;
    
    @NonNull
    private String name;
    
    @NonNull
    private Double price;
    
    @NonNull
    private Integer quanity;

    @Transient
    private int value;
}
