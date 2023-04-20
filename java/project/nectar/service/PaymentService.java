package project.nectar.service;

import org.springframework.transaction.annotation.Transactional;
import project.nectar.domain.PaymentDto;

public interface PaymentService {
    @Transactional(rollbackFor = Exception.class)
    Integer insert(PaymentDto paymentDto) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    Integer delete(PaymentDto paymentDto) throws Exception;
}
