package com.YourShopBazzar.YourShopBazzar.Service;

import com.YourShopBazzar.YourShopBazzar.Model.Cart;
import com.YourShopBazzar.YourShopBazzar.Model.Customer;
import com.YourShopBazzar.YourShopBazzar.Repository.CustomerRepository;
import com.YourShopBazzar.YourShopBazzar.RequestDto.CustomerRequestDto;
import com.YourShopBazzar.YourShopBazzar.convertor.CustomerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto){

        Customer customer = CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);

        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);
        return "Congrats !! Welcome to China Market.";
    }
}