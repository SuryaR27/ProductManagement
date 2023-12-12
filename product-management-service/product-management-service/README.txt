Product Management Service

The Product Management Service is a backend system designed to
facilitate the digital product management process
within a B2B SaaS ecosystem.
It provides a RESTful API for basic CRUD (Create, Read, Update, Delete)
operations on digital products.

Technologies Used
- Java
- Spring Boot
- Lombok
- MongoDB

Endpoints:
Get All Products-
GET /products
curl -X GET http://localhost:8080/products

Get Product by ID-
GET /products/{product_id}

{
    "id": "1",
    "name": "Product1",
    "description": "Description1",
    "price": 19.99,
    "availability": true
}

 Add New Product-
 POST /products
curl -X POST -H "Content-Type: application/json" -d '{"name":"NewProduct","description":"NewDescription","price":29.99,"availability":true}' http://localhost:8080/products

{
    "id": "2",
    "name": "NewProduct",
    "description": "NewDescription",
    "price": 29.99,
    "availability": true
}

Update Product by ID-
PUT /products/{product_id}
{
    "id": "2",
    "name": "UpdatedProduct",
    "description": "UpdatedDescription",
    "price": 39.99,
    "availability": false
}

Delete Product by ID-
curl -X DELETE http://localhost:8080/products/2
{
    "message": "Product deleted successfully"
}



























