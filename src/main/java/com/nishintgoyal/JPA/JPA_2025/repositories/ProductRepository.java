package com.nishintgoyal.JPA.JPA_2025.repositories;

import com.nishintgoyal.JPA.JPA_2025.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{
    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);
}
