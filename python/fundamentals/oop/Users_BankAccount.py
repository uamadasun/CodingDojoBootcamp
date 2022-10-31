from BankAccount import BankAccount

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)
        
    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        if self.account.balance>amount:
            self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        self.account.display_account_info()
        return self


first_user = User("Marissa", "marissa@gmail.com")
first_user.make_deposit(5000).make_withdrawal(500).display_user_balance()
