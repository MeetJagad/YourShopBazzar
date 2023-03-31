package com.YourShopBazzar.YourShopBazzar.Repository;

import com.YourShopBazzar.YourShopBazzar.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
