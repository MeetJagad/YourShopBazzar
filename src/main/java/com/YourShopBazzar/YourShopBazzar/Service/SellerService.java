package com.YourShopBazzar.YourShopBazzar.Service;

import com.YourShopBazzar.YourShopBazzar.Model.Seller;
import com.YourShopBazzar.YourShopBazzar.Repository.SellerRepository;
import com.YourShopBazzar.YourShopBazzar.RequestDto.SellerRequestDto;
import com.YourShopBazzar.YourShopBazzar.convertor.SellerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepo;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepo.save(seller);

        return "Congrats! Now you can sell on Chine Market !!!";
    }
}
