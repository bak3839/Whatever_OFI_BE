package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.responseDto.BoardDetailRes;
import com.whatever.ofi.responseDto.UserMainPageRes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository {
    @PersistenceContext
    EntityManager em;

    public Board findOne(Long id) {
       return em.find(Board.class, id);
    }

    public void save(Board board) {
        em.persist(board);
    }

    public List<BoardDetailRes> findBoardDetail(Long id) {
        Object[] resultBoard = em.createQuery(
                        " select c.nickname, c.image_url, b.image_url, b.like_count, c.request_count, b.style, b.content " +
                                " from Board b, Coordinator c " +
                                " where b.coordinator.id = c.id and b.id = :id" +
                                " group by c.id " , Object[].class)
                .setParameter("id", id)
                .getSingleResult();

//        List<BoardDetailRes> dtos = new ArrayList<>();
//
//        for (Object[] result : resultList) {
//            BoardDetailRes dto = BoardDetailRes.builder()
//                    .nickname((String) result[0])
//                    .profile_image((String) result[1])
//                    .board_image((String) result[2])
//                    .like_count((Integer) result[3])
//                    .request_count((Integer) result[4])
//                    .style((String) result[5])
//                    .content((String) result[6])
//                    .build();
//
//            dtos.add(dto);
//        }

        return dtos;
    }

}
