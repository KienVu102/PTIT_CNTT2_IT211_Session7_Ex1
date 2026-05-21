package com.example.session7_ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/pay")
    public String processPayment() {
        boolean result = transactionService.processPayment("ACC123456", 1000.0);
        return result ? "Thanh toán thành công" : "Thanh toán thất bại";
    }

    @GetMapping("/transfer")
    public String transferMoney() {
        boolean result = transactionService.transferMoney("ACC111", "ACC222", 500.0);
        return result ? "Chuyển tiền thành công" : "Chuyển tiền thất bại";
    }

    @GetMapping("/balance")
    public String checkBalance() {
        boolean result = transactionService.checkBalance("ACC123456");
        return result ? "Kiểm tra số dư thành công" : "Kiểm tra số dư thất bại";
    }

    @GetMapping("/demo")
    public String demoAll() {
        System.out.println("=== DEMO DÀN ĐO HIỆU NĂNG VỚI AOP ===");
        transactionService.processPayment("ACC123456", 1000.0);
        transactionService.transferMoney("ACC111", "ACC222", 500.0);
        transactionService.checkBalance("ACC123456");
        System.out.println("=== KẾT THÚC DEMO ===");
        return "Demo hoàn tất! Xem console để xem log hiệu năng.";
    }
}

