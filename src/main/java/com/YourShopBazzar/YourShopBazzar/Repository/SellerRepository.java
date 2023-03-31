package com.YourShopBazzar.YourShopBazzar.Repository;

import com.YourShopBazzar.YourShopBazzar.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
