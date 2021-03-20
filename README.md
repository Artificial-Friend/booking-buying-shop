# Shop with booking products
***

## Requirements
#### In order to run this project you need to install JDK
***
## Warning!
#### Project uses AutoInjectMockData class that injects hardcoded data
***

### If you don't have a DB
1. h2 inMemory database is used. Just run project.

### If you have a DB
1. Change `url` in `application.properties`
2. Add your database dependency in 
3. Run project.
***

Go to `localhost:8080` and use appropriate url according co available controllers.

#### Registration:
POST `/register` , required parameters: `name` and `email`
#### Cart(`/carts`):
PATCH: `/{cartId}/add-product` to add a product, required parameters `productName`, `quantity`, `{cartId}` is same as user id
PATCH: `/{cartId}/remove-product` to add a product, required parameters `productName`, `{cartId}` is same as user id. `quantity` is an optional parameter if it's not set product will be removed with any quantities
#### Order(`/orders`):
PUT: `/client/{clientId}/complete-order` to complete order, `{clientId}` is required path variable
####  Product(`/products`):
GET: `name` parameter to get any product by its name
GET: `/ordered/by-popular` with no parameter to sort products by popularity (purchases)
GET: `/ordered/by-cheapest` with no parameter to sort purchased products by price from cheapest to the most expensive
GET: `/ordered/by-most-expensive` with no parameter to sort purchased products by price from the most expensive to cheapest

***

Tested via Postman.
