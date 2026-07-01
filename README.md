# 📚 Book Bazzar

Book Bazzar is a modular Java console application that simulates an online book marketplace. It features role-based dashboards for **Admins**, **Sellers**, and **Buyers** using a clean **Model-View-Presenter (MVP)** architecture and an in-memory database store.

---

## 🚀 Features

### 👤 User Onboarding
*   **Sign Up**: Create new accounts as a **Buyer** or **Seller**.
*   **Secure Login**: Role-based redirection to the respective dashboard.
*   **Default Admin Account**: Automatically pre-configured on application startup.

### 👑 Role-Based Dashboards
*   **Admin**: Complete system visibility. Can add books, update book details, inspect all seller inventories, place orders via shopping cart checkout, and review global order statistics.
*   **Seller**: Product management suite. Sellers can add new books, update titles/authors/prices of their own books, and view their active inventory.
*   **Buyer**: Client-side browsing and shopping. Buyers can search the book directory, add items to a cart, checkout, view order receipts, and maintain a personal list of favorite books.

---

## 🏛️ Project Architecture (MVP)

The codebase implements a decoupled **Model-View-Presenter** pattern to handle command-line interaction and separate UI logic from business logic.

```
                  ┌───────────────┐
                  │     View      │ (Handles user inputs & printing)
                  └───────┬───────┘
                          │
            User Choices  │  Updates / Responses
            & Input data  │
                          ▼
                  ┌───────────────┐
                  │   Presenter   │ (Performs validation & orchestrates action)
                  └───────┬───────┘
                          │
          Reads / Writes  │  Data Returns
                          ▼
                  ┌───────────────┐
                  │  Repository   │ (In-memory Mock Database Store)
                  └───────────────┘
```

*   **View Layer (`*View.java`)**: Responsible for scanning user inputs, displaying menus, and presenting console logs or status errors.
*   **Presenter Layer (`*Presenter.java`)**: Handles the business logic, input validation (e.g., non-empty titles, non-negative prices, valid usernames), and coordinates with the DB storage.
*   **Data Models (DTOs)**: Simple data objects like [User](file:///home/poovarasan/Desktop/BookBazzar/com/PoovarasanMoorthy29/bookbazzar/data/dto/User.java), [Book](file:///home/poovarasan/Desktop/BookBazzar/com/PoovarasanMoorthy29/bookbazzar/data/dto/Book.java), and [Order](file:///home/poovarasan/Desktop/BookBazzar/com/PoovarasanMoorthy29/bookbazzar/data/dto/Order.java).
*   **In-Memory Database**: Managed by the singleton [BookBazzarDB](file:///home/poovarasan/Desktop/BookBazzar/com/PoovarasanMoorthy29/bookbazzar/data/repository/BookBazzarDB.java).

---

## 📁 Directory Structure

```text
BookBazzar/
├── BookBazzarApp.java                 # App Entry point containing main() method
├── README.md                          # Project documentation
├── .gitignore                         # Git exclusion rules
└── com/PoovarasanMoorthy29/bookbazzar/
    ├── data/
    │   ├── dto/                       # Data transfer models (Book, User, Order, Role)
    │   └── repository/                # Mock DB Repository (BookBazzarDB)
    └── features/                      # Application feature packages (MVP views and presenters)
        ├── Login/                     # User sign-in flows
        ├── SignUp/                    # Registration flows
        ├── admin/                     # Admin control dashboard
        ├── seller/                    # Seller control dashboard
        ├── buyer/                     # Buyer control dashboard
        ├── addbook/                   # Add new book listing
        ├── updatebook/                # Edit book listing (with validation)
        ├── myInventory/               # Display user inventory
        ├── search/                    # Query listings by title/author
        ├── addtocart/                 # Shopping cart checkouts (immutable snapshot logs)
        ├── favouriteBooks/            # Favorite books management
        └── orders/                    # Order history reports
```

---

## 🔐 Default Credentials

To access the system as an Administrator upon startup:
*   **Username**: `admin`
*   **Password**: `admin123`
*   **Role**: `ADMIN`

---

## 🛠️ Build & Run Requirements

*   **Java Development Kit (JDK)**: Version 8 or newer.

### Compilation
From the project root directory, run the following to compile all Java source files and output compiled classes into the `out/` folder:
```bash
find . -name "*.java" > sources.txt
javac -d out @sources.txt
```

### Running the App
Execute the compiled application with:
```bash
java -cp out BookBazzarApp
```

---

## 📝 Persistence Note
This application runs **fully in-memory**. All data resets when the application process is terminated.
