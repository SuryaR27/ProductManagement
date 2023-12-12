package com.immutly.productmanagement.Service;

public class ProductIDGenerator {

    private static Integer product_ID = 0;

    public static Integer getId(){
        return ++product_ID;
    }

}
