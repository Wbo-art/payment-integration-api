
package com.abate.payment.controller;

import com.abate.payment.dto.CreatePaymentRequest;
import com.abate.payment.entity.Payment;
import com.abate.payment.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment createPayment(
            @Valid @RequestBody CreatePaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable String id) {
        return paymentService.getPayment(id);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
