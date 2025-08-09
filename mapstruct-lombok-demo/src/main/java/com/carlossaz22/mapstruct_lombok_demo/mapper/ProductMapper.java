package com.carlossaz22.mapstruct_lombok_demo.mapper;

import com.carlossaz22.mapstruct_lombok_demo.dto.GetProduct;
import com.carlossaz22.mapstruct_lombok_demo.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    @Mappings(
            {
                    //Si los atributos se llaman igual no es necesario agregarlos
                    //@Mapping(source = "id", target = "id"),
                    //@Mapping(source = "name", target = "name"),
                    @Mapping(source = "creationDate", target = "creationDate",
                            dateFormat = "yyyy-MM-dd HH:mm:ss")
            }
    )
    GetProduct toGetDTO(Product product);


    @InheritInverseConfiguration
    Product toEntity(GetProduct getproduct);


    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getproductList);
}
