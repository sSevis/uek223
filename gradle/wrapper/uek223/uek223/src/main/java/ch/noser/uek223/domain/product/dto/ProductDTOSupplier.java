package ch.noser.uek223.domain.product.dto;

import ch.noser.uek223.domain.product.Availability;
import ch.noser.uek223.domain.user.dto.UserDTOSupplier;

import java.util.UUID;
import java.util.function.Supplier;

public class ProductDTOSupplier {


    private UUID id;

    private float buyingPrice;

    private float sellingPrice;

    private String description;

    private Availability availability;

    private UserDTOSupplier supplier;

    public ProductDTOSupplier(UUID id, float buyingPrice, float sellingPrice) {
        this.id = id;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public ProductDTOSupplier() {
    }

    public UUID getId() {
        return id;
    }

    public ProductDTOSupplier setId(UUID id) {
        this.id = id;
        return this;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public ProductDTOSupplier setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
        return this;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public ProductDTOSupplier setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }
}
