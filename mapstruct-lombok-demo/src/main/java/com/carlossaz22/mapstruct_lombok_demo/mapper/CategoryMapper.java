package com.carlossaz22.mapstruct_lombok_demo.mapper;

import com.carlossaz22.mapstruct_lombok_demo.dto.GetCategory;
import com.carlossaz22.mapstruct_lombok_demo.entity.Category;
import com.carlossaz22.mapstruct_lombok_demo.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {
    @Mappings(
            {
                    @Mapping(source = "name", target = "categoryName"),
                    @Mapping(source = "id", target = "categoryId")
            }
    )
    abstract GetCategory toGetCategory(Category category);

    @Autowired
    private CategoryRepository categoryRepository;

    Category toEntity(GetCategory getCategory){
        if(getCategory == null) return null;
        Category category = categoryRepository.findById(getCategory.getCategoryId())
                .orElse(null);

        if(category == null) return null;

        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());

        return category;
    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);

    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);
}
