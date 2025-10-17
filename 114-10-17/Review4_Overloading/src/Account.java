import java.util.Scanner;

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

    public Account() {
        this("000000", 0.0);
    }

    public Account(String accountNumber) {
        this(accountNumber, 0.0);
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

    @FunctionalInterface
    private interface DoubleValidator {
        boolean isValid(double value);
    }

    private double getValidAmount(double initialValue, DoubleValidator validator, String prompt) {
        double value = initialValue;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        while (!validator.isValid(value) && attempts < 3) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            attempts++;
        }
        if (!validator.isValid(value)) {
            throw new IllegalArgumentException(prompt);
        }
        return value;
    }

    public void setBalance(double balance) {
        this.balance = getValidAmount(
                balance,
                v -> v >= 0,
                "帳戶餘額必須大於等於0，請重新輸入："
        );
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        double validAmount = getValidAmount(
                amount,
                v -> v > 0,
                "存款金額必須大於0，請重新輸入："
        );
        balance += validAmount;
    }

    public void deposit(double amount, String currencyType) {
        double exchangeRate;
        switch (currencyType) {
            case "USD":
                exchangeRate = 30.0;
                break;
            case "EUR":
                exchangeRate = 33.0;
                break;
            case "JPY":
                exchangeRate = 0.28;
                break;
            default:
                throw new IllegalArgumentException("不支援的貨幣類型: " + currencyType);
        }
        double amountInTWD = amount * exchangeRate;
        deposit(amountInTWD);
    }

    public void deposit(double ...amounts) {
        double totalAmount = 0;
        for (double amount : amounts) {
            totalAmount += amount;
        }
        double validAmount = getValidAmount(
                totalAmount,
                v -> v > 0,
                "存款總金額必須大於0，請重新輸入："
        );
        balance += validAmount;
    }

    public void withdraw(double amount) {
        double validAmount = getValidAmount(
                amount,
                v -> v > 0 && v <= balance,
                "提款金額必須大於0且不可超過餘額，請重新輸入："
        );
        balance -= validAmount;
    }
}
