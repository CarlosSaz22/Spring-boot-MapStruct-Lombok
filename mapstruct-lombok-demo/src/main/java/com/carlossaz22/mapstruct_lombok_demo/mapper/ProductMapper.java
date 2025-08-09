package com.carlossaz22.mapstruct_lombok_demo.mapper;

import com.carlossaz22.mapstruct_lombok_demo.dto.GetProduct;
import com.carlossaz22.mapstruct_lombok_demo.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings(
            {
                    //Si los atributos se llaman igual no es necesario agregarlos
                    @Mapping(source = "id", target = "productId"),
                    @Mapping(source = "name", target = "productName"),
                    @Mapping(source = "creationDate", target = "creationDate",
                            dateFormat = "yyyy-MM-dd HH:mm:ss"),
                    @Mapping(source = "category", target = "productCategory"),
                    @Mapping(source = "price", target = "price",numberFormat = "$#0.00")
            }
    )
    GetProduct toGetDTO(Product product);


    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "creationDate", ignore = true),
    })
    Product toEntity(GetProduct getproduct);


    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getproductList);
}
