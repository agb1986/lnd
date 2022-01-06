package com.agb1986.lnd.unittesting.repositories;

import com.agb1986.lnd.unittesting.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
