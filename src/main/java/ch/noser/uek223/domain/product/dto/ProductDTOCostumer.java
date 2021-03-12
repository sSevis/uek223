package ch.noser.uek223.domain.product.dto;

import ch.noser.uek223.domain.product.Availability;

import java.util.UUID;

public class ProductDTOCostumer {

    private UUID id;

    private float sellingPrice;

    private String description;

    private Availability availability;

    public ProductDTOCostumer(UUID id, float sellingPrice) {
        this.id = id;
        this.sellingPrice = sellingPrice;
    }

    public ProductDTOCostumer() {
    }

    public UUID getId() {
        return id;
    }

    public ProductDTOCostumer setId(UUID id) {
        this.id = id;
        return this;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public ProductDTOCostumer setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }
}
