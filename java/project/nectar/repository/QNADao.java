package project.nectar.repository;

import project.nectar.domain.QNADto;

import java.util.List;

public interface QNADao {
    List<QNADto> selectAll();

    List<QNADto> selectAllByWriter(String qna_writer);

    QNADto select(Integer qna_NUM);

    QNADto selectByWriter(Integer qna_NUM, String qna_writer);

    Integer insert(QNADto qnaDto);

    public Integer update(QNADto qnaDto);

    public Integer delete(QNADto qnaDto);
}
