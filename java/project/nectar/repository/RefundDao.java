package project.nectar.repository;

import project.nectar.domain.RefundDto;

import java.util.List;

public interface RefundDao {
    List<RefundDto> selectAll(String bizAccount_email) throws Exception;

    RefundDto select(Integer refund_NUM) throws Exception;

    int insert(RefundDto refundDto) throws Exception;
}
