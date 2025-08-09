package com.carlossaz22.mapstruct_lombok_demo.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategory {
    private long categoryId;
    private String categoryName;
}
