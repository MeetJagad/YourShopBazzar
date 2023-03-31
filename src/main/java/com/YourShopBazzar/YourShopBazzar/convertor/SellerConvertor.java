package com.YourShopBazzar.YourShopBazzar.convertor;

import com.YourShopBazzar.YourShopBazzar.Model.Seller;
import com.YourShopBazzar.YourShopBazzar.RequestDto.SellerRequestDto;
import lombok.experimental.UtilityClass;

import java.security.Provider;
//@UtilityClass
public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();


    }
}
