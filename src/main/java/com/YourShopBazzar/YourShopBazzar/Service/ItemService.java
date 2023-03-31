package com.YourShopBazzar.YourShopBazzar.Service;

import com.YourShopBazzar.YourShopBazzar.Exception.ProductNotFoundException;
import com.YourShopBazzar.YourShopBazzar.Model.Item;
import com.YourShopBazzar.YourShopBazzar.Model.Product;
import com.YourShopBazzar.YourShopBazzar.Repository.ProductRepository;
import com.YourShopBazzar.YourShopBazzar.ResponseDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {

        Product product;
        try{
            product = productRepository.findById(productId).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Sorry! Invalid product id.");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        // map item to product
        product.setItem(item);

        // save both item and product
        productRepository.save(product);

        // prepare the response dto
        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }
}
