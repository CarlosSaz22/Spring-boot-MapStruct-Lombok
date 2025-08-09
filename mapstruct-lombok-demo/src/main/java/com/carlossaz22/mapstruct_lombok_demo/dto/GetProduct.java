package com.carlossaz22.mapstruct_lombok_demo.dto;


import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private long productId;
    private String productName;
    private String creationDate;
    private GetCategory productCategory;
    private String price;


}
