# Book Bazzar

Book Bazzar is a Java console application for managing a simple online book marketplace. It supports role-based flows for admins, sellers, and buyers using an in-memory data store.

## Features

- User login and sign up
- Role-based dashboards for Admin, Seller, and Buyer
- Add and update books
- View seller/admin inventory
- Search books
- Add books to cart and checkout
- Manage favourite books
- View orders

## Default Login

The application creates one default admin account when it starts:

```text
Username: admin
Password: admin123
Role: ADMIN
```

## Project Structure

```text
BookBazzarApp.java
com/PoovarasanMoorthy29/bookbazzar/
  data/
    dto/              Data classes such as Book, User, Order, and Role
    repository/       In-memory BookBazzarDB storage
  features/
    Login/            Login flow
    SignUp/           User registration flow
    admin/            Admin dashboard
    seller/           Seller dashboard
    buyer/            Buyer dashboard
    addbook/          Add book flow
    updatebook/       Update book flow
    myInventory/      Inventory view
    search/           Book search flow
    addtocart/        Cart and checkout flow
    favouriteBooks/   Favourite books flow
    orders/           Orders flow
```

## Requirements

- Java JDK 8 or later

## Run

From the project root:

```bash
find . -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out BookBazzarApp
```

## Notes

- Data is stored in memory, so books, users, carts, favourites, and orders reset when the application stops.
- The app currently runs fully in the terminal and does not use a database or external dependencies.
