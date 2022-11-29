public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount(50, 20);
        firstAccount.depositMoney("savings", 100);
        BankAccount secondAccount = new BankAccount(120, 100);
        System.out.println(BankAccount.getTotalAccounts());
        secondAccount.withdrawMoney("savings", 100);
        System.out.println(secondAccount.getSavingsBalance());
    }
}