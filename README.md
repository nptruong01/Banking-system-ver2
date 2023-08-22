# Banking Transaction Management System Version 2

Welcome to the **Banking Transaction Management System** Version 2! This application is designed to provide a comprehensive solution for managing various banking transactions through an intuitive Java Swing-based graphical user interface.

## Functionality

### Customer Information Management

#### Add
When a customer visits the bank, they provide their information using a designated form. An employee then inputs the customer's personal details into the system, including full name, ID number, gender, address, and more.

#### Delete
Customers who no longer require banking services can request their information to be deleted. After confirming their account ownership, an employee will proceed to remove their details.

#### Update
Customers needing to modify their personal information can request updates. Following account ownership verification, an employee will update the customer's information accordingly.

### Employee Account Management

As the system is introduced, an all-access account (Admin) is provided to system administrators. This account enables the creation of sub-accounts tailored to specific tasks.

#### Add
When a new employee is hired, the system administrator generates an account, including personal information and login credentials.

#### Delete
Upon an employee's departure from the bank, the system administrator deletes their account.

#### Update
For password resets or personal information updates, the system administrator handles the necessary changes.

Employees operate based on their account permissions assigned by the system administrator. They log in to perform tasks such as customer information management, deposits, transfers, withdrawals, and balance inquiries.

### Deposit

When customers wish to deposit funds, they visit the bank and request a deposit. Employees authenticate them using their ID and personal information. The system checks for account locks and then processes the deposit, updating the account balance.

### Withdrawal

Customers visiting the bank for withdrawals provide ID and personal information for authentication. The system checks account locks and sufficient funds (withdrawal amount < account balance) before processing the withdrawal.

### Money Transfer

To transfer funds, customers provide ID, personal information, and recipient account number for authentication. Account locks and sufficient funds (transfer amount < account balance) are verified before processing the transfer.

### Check Balance

Customers seeking account balances provide ID and personal information for authentication. Employees then display the account's current balance.

### Transaction History

Customers requesting transaction histories (deposits, withdrawals, transfers) authenticate with their ID and personal information. Employees provide transaction history statements in print for customers to review.

## Screenshots

Here are some screenshots showcasing the user interface of the application:

<div align="center">

### Login Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/9da8da20-cb92-40f8-9487-ea78cb6f78d0.png" alt="Login Form" width="450"/>

### Homepage Form Interface (For "NhânViên" Account)
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/a1fa3e07-aa7c-4270-9414-584716cb7bb9.png" alt="Homepage for Employee" width="450"/>

### Homepage Form Interface (For "ADMIN" Account)
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/53fa7933-5c90-4b68-a731-db84d596b9e9.png" alt="Homepage for Admin" width="450"/>

### Customer Information Management Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/ce8668ba-8fd5-4bf7-81f9-5b231e17544f.png" alt="Customer Info Management Form" width="450"/>

### Account Information Management Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/e212c3c9-84e9-49f8-aab2-6869c3d43479.png" alt="Account Info Management Form" width="450"/>

### Deposit Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/fc74b90a-b5b9-430c-8d89-5bbe8dc89f2e.png" alt="Deposit Form" width="450"/>

### Withdrawal Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/f27967f9-b5a2-4582-a53c-b28c404440df.png" alt="Withdrawal Form" width="450"/>

### Money Transfer Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/de3ea885-de8e-4863-a0bc-d08fc58198db.png" alt="Money Transfer Form" width="450"/>

### Transaction History and Invoice Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/4d7c0662-91fe-4494-8848-47097830179a.png" alt="Transaction History and Invoice Form" width="450"/>

### Check Balance Form Interface
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/b88fdf04-1a37-4582-9b5f-cef4e259aeca.png" alt="Check Balance Form" width="450"/>

### Lock/Unlock Account Form Interface (Only for ADMIN)
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/9dcc96c9-071c-4177-bb16-9c1acc783723.png" alt="Lock/Unlock Account Form" width="450"/>

### User Account Management Form Interface (Only for ADMIN)
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/b36ed478-12bc-4329-ba92-d4cac24ad207.png" alt="User Account Management Form" width="450"/>

### Branch Management Form Interface (Only for ADMIN)
<img src="https://github.com/nptruong01/Banking-system-ver2/assets/113322089/c0e8aceb-adbc-4ef4-9bcb-3874fcef193a.png" alt="Branch Management Form" width="450"/>

</div>


## Getting Started

To get started with the **Banking Transaction Management System Version 2**, follow these steps:

1. Clone or download the repository to your local machine.
2. Run the application using your preferred Java IDE.
3. Explore the various functionalities and experience the seamless transaction management firsthand.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

We welcome your feedback and contributions to enhance and optimize this banking system further.

---

*Please note that the screenshots and paths mentioned in this README are based on fictional data and URLs. Make sure to replace them with actual URLs and paths corresponding to your hosted images and files.*
