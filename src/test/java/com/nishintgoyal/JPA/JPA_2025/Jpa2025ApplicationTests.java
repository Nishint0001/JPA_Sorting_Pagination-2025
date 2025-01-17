package com.nishintgoyal.JPA.JPA_2025;
import com.nishintgoyal.JPA.JPA_2025.entities.ProductEntity;
import com.nishintgoyal.JPA.JPA_2025.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.math.BigDecimal;

@SpringBootTest
class Jpa2025ApplicationTests
{
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads()
	{

	}

	@Test
	void testRepository()
	{
		ProductEntity productEntity=ProductEntity.builder()
				.sku("nishint2025")
				.title("Fighter")
				.price(BigDecimal.valueOf(123.45))
				.quantity(10)
				.build();

	ProductEntity savedProductEntity=productRepository.save(productEntity);
	System.out.println(savedProductEntity);
	}

	@Test
	void getRepositoryAll()
	{
		List<ProductEntity> entities = productRepository.findAll();
		System.out.println(entities.toString());
	}

	@Test
	void getRepositoryByTitle()
	{
		List<ProductEntity> entities = productRepository.findByOrderByPrice();
		System.out.println(entities.toString());
	}

	@Test
	void getRepositoryExperiment1()
	{
		List<ProductEntity> entities=productRepository.findByQuantityGreaterThanOrPriceLessThan(4,BigDecimal.valueOf(1));
		System.out.println(entities);
	}
	@Test
	void getRepositoryExperiment2()
	{
		List<ProductEntity> entities=productRepository.findByTitleLike("%n%");
		System.out.println(entities);
	}
}
