package com.example.session7_ex1;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public boolean processPayment(String accountNumber, double amount) {
        System.out.println("SERVICE: Đang xử lý thanh toán cho tài khoản " + accountNumber);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("SERVICE: Đang chuyển tiền từ " + fromAccount + " đến " + toAccount);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public boolean checkBalance(String accountNumber) {
        System.out.println("SERVICE: Kiểm tra số dư tài khoản " + accountNumber);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }
}