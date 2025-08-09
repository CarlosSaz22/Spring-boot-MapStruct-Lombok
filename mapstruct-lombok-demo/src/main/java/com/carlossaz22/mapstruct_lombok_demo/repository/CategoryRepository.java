package com.carlossaz22.mapstruct_lombok_demo.repository;

import com.carlossaz22.mapstruct_lombok_demo.entity.Category;
import com.carlossaz22.mapstruct_lombok_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
