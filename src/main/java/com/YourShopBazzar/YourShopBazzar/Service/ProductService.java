package com.YourShopBazzar.YourShopBazzar.Service;

import com.YourShopBazzar.YourShopBazzar.Enum.ProductCategory;
import com.YourShopBazzar.YourShopBazzar.Exception.SellerNotFoundException;
import com.YourShopBazzar.YourShopBazzar.Model.Product;
import com.YourShopBazzar.YourShopBazzar.Model.Seller;
import com.YourShopBazzar.YourShopBazzar.Repository.ProductRepository;
import com.YourShopBazzar.YourShopBazzar.Repository.SellerRepository;
import com.YourShopBazzar.YourShopBazzar.RequestDto.ProductRequestDto;
import com.YourShopBazzar.YourShopBazzar.ResponseDto.ProductResponseDto;
import com.YourShopBazzar.YourShopBazzar.convertor.ProductConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {

        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch(Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Product product = ProductConvertor.productRequestDtotoProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        // saved the seller and product - parent and child
        sellerRepository.save(seller);

        // prepare response
        ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
        return productResponseDto;
    }

    public List<ProductResponseDto> getProductsByCategory(ProductCategory productCategory){

        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        // prepare a list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
