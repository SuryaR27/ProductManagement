package com.immutly.productmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private Integer product_id;
    private String product_Name;
    private String Product_Description;
    private Double product_Price;
    private String product_Availability;

}
