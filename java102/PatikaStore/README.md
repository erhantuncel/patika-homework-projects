# Patika Store

Product Management System for Patika Store that sells electronical devices.

## Requirements

- Brand properties
    
    ```
    id : Unique number
    name : Brand name
    ```

- Brands should be listed with alphabetical order.
- Brands should be added with static code blocks with order below
    ```
     Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster 
     ```

- It is planned to sell two product category in which Mobile Phone and Notebook for now.
- It should be designed that can be added new categories in the future.
- Mobile Phone properties:
    
    ```
    id : Unique number
    unitPrice : Unit price
    discountRate : Discount rate
    amount : Amount of stock
    name : Product name
    brand : Brand that is described in system.
    memory : Memory of mobile phone. (128 GB, 64 GB)
    screenSize: Size of mobile phone screen. (6.1 Inc)
    batteryPower: Power of battery. (4000)
    ram: RAM (6 MB)
    color: Color of mobile phone. (Black, red ...)
    ```

- Notebook properties:

    ```
    id : Unique number
    unitPrice : Unit price
    discountRate : Discount rate
    amount : Amount of stock
    name : Product name
    brand : Brand that is described in system.
    ram: RAM (6 MB)
    storage: Storage of notebook (512 SSD)
    screenSize: Size of mobile phone screen. (14 Inc)
    ```
- Users should be able to list products based on categories (Mobile Phone, Notebook etc.).
- Products should be listed in table format in console screen.
- Users should be able to add product and select its category (Mobile Phone, Notebook etc.).
- Users should be able to delete product by its unique number.
- Users should be able to filter and list products by its unique number and brand.
