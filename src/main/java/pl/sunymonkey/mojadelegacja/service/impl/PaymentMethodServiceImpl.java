package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.PaymentMethod;
import pl.sunymonkey.mojadelegacja.repository.PaymentMethodRepository;
import pl.sunymonkey.mojadelegacja.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod findByMethod(String method) {
        return paymentMethodRepository.findByMethod(method);
    }
}
