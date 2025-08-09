package com.carlossaz22.mapstruct_lombok_demo.test;

import com.carlossaz22.mapstruct_lombok_demo.dto.GetProduct;
import com.carlossaz22.mapstruct_lombok_demo.entity.Product;
import com.carlossaz22.mapstruct_lombok_demo.mapper.ProductMapper;
import com.carlossaz22.mapstruct_lombok_demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return args -> {
            List<Product> products = productRepository.findAll();
            log.info("PRODUCTS : {}");
            products.forEach(product -> log.info(product.toString()));

            log.info("GET PRODUCT : {}");
            List<GetProduct> getProductList = productMapper.toGetProductList(products);
            getProductList.forEach(product -> log.info(product.toString()));



            log.info("MAPPED PRODUCTS : {}");
            List<Product> productsListMapped = productMapper.toEntityList(getProductList);
            productsListMapped.forEach(product -> log.info(product.toString()));


        };
    }
}
