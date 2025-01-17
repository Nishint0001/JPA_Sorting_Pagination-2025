
package com.nishintgoyal.JPA.JPA_2025.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "Product_Table",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_uniques", columnNames = {"sku"})
        },
        indexes = {
                @Index(name = "sku_index", columnList = "sku")
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 22)
    private String sku;

    @Column(name = "title_x")
    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Private constructor to ensure the builder is used
    public ProductEntity()
    {

    }
    private ProductEntity(ProductEntityBuilder builder) {
        this.id = builder.id;
        this.sku = builder.sku;
        this.title = builder.title;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    // Static method to create a builder
    public static ProductEntityBuilder builder() {
        return new ProductEntityBuilder();
    }

    // Custom builder class for ProductEntity
    public static class ProductEntityBuilder {
        private Long id;
        private String sku;
        private String title;
        private BigDecimal price;
        private Integer quantity;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // Setters for each field (returns the builder itself)
        public ProductEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductEntityBuilder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public ProductEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductEntityBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductEntityBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductEntityBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductEntityBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        // The method that builds the ProductEntity object
        public ProductEntity build() {
            return new ProductEntity(this);
        }
    }

    // Getters (Lombok @Data annotation would automatically generate them)
    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

