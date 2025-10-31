import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001", "Alice","a123","a123", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob","b123", "b234", 3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie","s", "123" -100);
        addCustomer(customers, acc3);

        operation(customers);
    }

    public static void operation(List<Account> customers) {
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount = null;
        while (true) {
            menu();
            System.out.print("請選擇功能(1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除換行符號

            switch (choice) {
                case 1: // 新增客戶
                    System.out.print("輸入帳戶號碼: ");
                    String accNum = scanner.nextLine();
                    System.out.print("輸入持有人名稱: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("輸入初始餘額: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    Account newAccount = new Account(accNum, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;

                case 2: // 存款
                    System.out.print("輸入要存款的帳戶號碼: ");
                    String depositAccNum = scanner.nextLine();
                    Account depositAccount = customerInAction(customers, depositAccNum);
                    if (depositAccount == null) break;
                    System.out.print("輸入存款金額: ");
                    double depAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        depositAccount.deposit(depAmount);
                        System.out.println("存款成功。帳戶 " + depositAccount.getAccountNumber() +
                                " 目前餘額: " + depositAccount.getBalance());
                    } catch (IllegalArgumentException e) {
                        System.out.println("存款失敗: " + e.getMessage());
                    }
                    break;

                case 3: // 提款
                    System.out.print("輸入要提款的帳戶號碼: ");
                    String withdrawAccNum = scanner.nextLine();
                    Account withdrawAccount = customerInAction(customers, withdrawAccNum);
                    if (withdrawAccount == null) break;
                    System.out.print("輸入提款金額: ");
                    double withAmount = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        withdrawAccount.withdraw(withAmount);
                        System.out.println("提款成功。帳戶 " + withdrawAccount.getAccountNumber() +
                                " 目前餘額: " + withdrawAccount.getBalance());
                    } catch (IllegalArgumentException e) {
                        System.out.println("提款失敗: " + e.getMessage());
                    }
                    break;

                case 4: // 查詢指定帳戶
                    System.out.print("輸入要查詢的帳戶號碼: ");
                    String searchAccNum = scanner.nextLine();
                    selectedAccount = customerInAction(customers, searchAccNum);
                    printCustomerInfo(selectedAccount);
                    break;

                case 5: // 顯示所有帳戶
                    System.out.println("\n所有客戶帳戶資訊:");
                    printCustomerAccounts(customers);
                    break;

                case 6: // 刪除帳戶
                    System.out.print("輸入要刪除的帳戶號碼: ");
                    String deleteAccNum = scanner.nextLine();
                    deleteCustomer(customers, deleteAccNum);
                    break;

                case 7: // 離開
                    System.out.println("離開系統，謝謝使用!");
                    return;

                default:
                    System.out.println("無效的選擇，請重新輸入");
            }
        }
    }

    public static Account customerInAction(List<Account> customers, String accountNumber) {
        for (Account account : customers) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
        return null;
    }

    public static void addCustomer(List<Account> customers, Account newAccount) {
        customers.add(newAccount);
        System.out.println("新增客戶成功: " + newAccount.getAccountNumber());
    }

    public static void deleteCustomer(List<Account> customers, String accountNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                Account removedAccount = customers.remove(i);
                System.out.println("刪除客戶成功: " + removedAccount.getAccountNumber() + " (" + removedAccount.getOwnerName() + ")");
                return;
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
    }

    public static void printCustomerAccounts(List<Account> customers) {
        for (Account customer : customers) {
            printCustomerInfo(customer);
        }
    }

    public static void printCustomerInfo(Account account) {
        if (account == null) {
            System.out.println("無法列印帳戶資訊，帳戶不存在");
            return;
        }
        System.out.println(account.toString());
    }

    public static void menu() {
        System.out.println("\n========== 功能選單 ==========");
        System.out.println("1. 新增客戶");
        System.out.println("2. 存款");
        System.out.println("3. 提款");
        System.out.println("4. 查詢指定帳戶");
        System.out.println("5. 顯示所有帳戶");
        System.out.println("6. 刪除帳戶");
        System.out.println("7. 離開");
        System.out.println("==============================");
    }
}