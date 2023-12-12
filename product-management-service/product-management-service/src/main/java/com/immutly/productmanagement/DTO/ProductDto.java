package com.immutly.productmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String product_Name;
    private String product_Description;
    private Double product_Price;
    private String product_Availability;

}
