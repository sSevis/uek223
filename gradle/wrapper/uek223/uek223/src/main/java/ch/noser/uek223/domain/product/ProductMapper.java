package ch.noser.uek223.domain.product;

import ch.noser.uek223.domain.product.dto.ProductDTOAdmin;
import ch.noser.uek223.domain.product.dto.ProductDTOCostumer;
import ch.noser.uek223.domain.product.dto.ProductDTOSupplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTOSupplier productToProductDTOSupplier(Product product);

    ProductDTOCostumer productToProductDTOCostumer(Product product);

    ProductDTOAdmin productToProductDTOAdmin(Product product);

}
