package com.carlossaz22.mapstruct_lombok_demo.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private long id;
    private String name;

    private String creationDate;


}
