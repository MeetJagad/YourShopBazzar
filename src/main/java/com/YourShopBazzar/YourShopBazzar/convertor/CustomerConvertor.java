package com.YourShopBazzar.YourShopBazzar.convertor;


import com.YourShopBazzar.YourShopBazzar.Model.Customer;
import com.YourShopBazzar.YourShopBazzar.RequestDto.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }
}
