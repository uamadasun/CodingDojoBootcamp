class BankAccount:
    all_instances = []

    def __init__(self, int_rate, balance=0):
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_instances.append(self)

    def deposit(self,amount):
        self.balance += amount
        return self

    def withdraw(self,amount):
        if self.balance > amount:
            self.balance -= amount
        else:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        return self

    def display_account_info(self):
        formatted_balance = "{:.2f}".format(self.balance)
        print(f'Balance: ${formatted_balance}')
        return self

    def yield_interest(self):
        if self.balance > 0:
            self.balance = self.balance + (self.balance*self.int_rate)
        return self

    @classmethod
    def print_instances(cls):
        for instance in cls.all_instances:
            instance.display_account_info()

# first_account = BankAccount(0.01, 100)
# second_account = BankAccount(0.02,1000)

# first_account.deposit(100).deposit(50).deposit(274).withdraw(340).yield_interest().display_account_info()
# second_account.deposit(500).deposit(69).withdraw(69).withdraw(500).withdraw(900).withdraw(50).yield_interest().display_account_info()

# BankAccount.print_instances()
