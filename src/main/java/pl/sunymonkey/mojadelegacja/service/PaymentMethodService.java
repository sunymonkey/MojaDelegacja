package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.PaymentMethod;

public interface PaymentMethodService {
    PaymentMethod save(PaymentMethod paymentMethod);
    PaymentMethod findByMethod(String method);
}
