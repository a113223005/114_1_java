public class Account {
    private String accountNumber;
    private double balance;

    /**
     * 建構子
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */

    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，設定餘額為0");
            this.balance = 0;
        }
    }

    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 0) {
            this.balance = balance;
        }else{
            throw new IllegalArgumentException("帳戶餘額必須為整數");
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為整數");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }
}





