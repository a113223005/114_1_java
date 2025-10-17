public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private static int accountCount = 0; // 新增帳戶計數

    /**
     * 建構子
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName; // 設定擁有者名稱
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage() + "，設定餘額為0");
            this.balance = 0; // 確實將餘額設為0
        }
        accountCount++;
    }

    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("帳戶餘額必須為非負數");
        }
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須為正數");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額無效或餘額不足");
        }
    }
}