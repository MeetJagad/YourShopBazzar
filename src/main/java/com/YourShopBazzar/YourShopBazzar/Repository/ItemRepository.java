package com.YourShopBazzar.YourShopBazzar.Repository;

import com.YourShopBazzar.YourShopBazzar.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
