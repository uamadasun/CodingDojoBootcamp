public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int totalAccounts = 0;
    private static double totalMoneyInAccount = 0;

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        totalAccounts++;
        totalMoneyInAccount = this.checkingBalance + this.savingsBalance;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static double getAccountTotal() {
        return totalMoneyInAccount;
    }

    public static double getTotalAccounts() {
        return totalAccounts;
    }

    public void depositMoney(String accountType, double amountToDeposit) {
        if (accountType == "checking") {
            this.checkingBalance += amountToDeposit;
            totalMoneyInAccount+=amountToDeposit;
            
        }
        else if (accountType == "savings") {
            this.savingsBalance += amountToDeposit;
            totalMoneyInAccount+=amountToDeposit;
        }
        else {
            System.out.println("Invalid account type. Try again!");
        }
    }

    public void withdrawMoney(String accountType, double amountToWithdraw) {
        if (accountType =="checking") {
            if (amountToWithdraw > this.checkingBalance) {
                System.out.println("Insufficient funds, try again!");
            } else{
                this.checkingBalance -= amountToWithdraw;
                totalMoneyInAccount -= amountToWithdraw;
            }
        }
        else if (accountType == "savings") {
            if (amountToWithdraw > this.savingsBalance) {
                System.out.println("Insufficient funds, try again!");
            }
            else {
                this.savingsBalance -= amountToWithdraw;
                totalMoneyInAccount -= amountToWithdraw;
            }
        }
        else {
            System.out.println("Invalid account type. Try again.");
        }

    }
    
    
}