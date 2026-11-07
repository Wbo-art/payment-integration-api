
package com.abate.payment.service;

import com.abate.payment.dto.CreatePaymentRequest;
import com.abate.payment.entity.Payment;
import com.abate.payment.entity.PaymentStatus;
import com.abate.payment.repository.PaymentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment createPayment(CreatePaymentRequest request) {

        if (request.sourceAccount().equals(
                request.destinationAccount())) {
            throw new IllegalArgumentException(
                    "Source and destination accounts must be different"
            );
        }

        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                request.sourceAccount(),
                request.destinationAccount(),
                request.amount(),
                request.currency(),
                request.description(),
                PaymentStatus.SUCCESS,
                Instant.now()
        );

        // SUCCESS is simulated, not a real money transfer.
        return paymentRepository.save(payment);
    }

    public Payment getPayment(String id) {
        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Payment not found: " + id
                        )
                );
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
