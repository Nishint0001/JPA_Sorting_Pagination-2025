package com.nishintgoyal.JPA.JPA_2025.controllers;

import com.nishintgoyal.JPA.JPA_2025.entities.ProductEntity;
import com.nishintgoyal.JPA.JPA_2025.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController
{
    private final int pageSize=5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue="id") String sortBy)
    {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,sortBy));
    }

    @GetMapping("/pages")
    public List<ProductEntity> getAllPages(@RequestParam(defaultValue = "0") Integer PageNumber)
    {
        Pageable pageable= PageRequest.of(PageNumber, pageSize);
        return productRepository.findAll(pageable).getContent();
    }

}
