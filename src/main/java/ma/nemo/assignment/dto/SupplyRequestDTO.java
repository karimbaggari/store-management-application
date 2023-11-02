package ma.nemo.assignment.dto;

import java.sql.Date;
import java.time.LocalDate;

public class SupplyRequestDTO {
    private Long productId;
    private Integer quantity;
    private Date supplyDate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    // getters and setters
}
