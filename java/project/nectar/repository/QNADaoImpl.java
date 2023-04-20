package project.nectar.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.nectar.domain.QNADto;

import java.util.List;

@Repository
public class QNADaoImpl implements QNADao {
    @Autowired
    SqlSession session;
    private String namespace="project.nectar.repository.QNAMapper.";


    @Override
    public List<QNADto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }


    @Override
    public List<QNADto> selectAllByWriter(String qna_writer){
        return session.selectList(namespace+"selectAllByWriter", qna_writer);
    }

    @Override
    public QNADto select(Integer qna_NUM){
        return session.selectOne(namespace+"select",qna_NUM);
    }

    @Override
    public QNADto selectByWriter(Integer qna_NUM, String qna_writer){
        QNADto qnaDto = new QNADto();
        qnaDto.setQna_NUM(qna_NUM);
        qnaDto.setQna_writer(qna_writer);
        return session.selectOne(namespace+"selectByWriter",qnaDto);
    }

    @Override
    public Integer insert(QNADto qnaDto){
        return session.insert(namespace+"insert",qnaDto);
    }

    @Override
    public Integer update(QNADto qnaDto){
        return session.update(namespace + "update", qnaDto);
    }

    @Override
    public Integer delete(QNADto qnaDto){
        return session.delete(namespace + "delete" , qnaDto);
    }

}
