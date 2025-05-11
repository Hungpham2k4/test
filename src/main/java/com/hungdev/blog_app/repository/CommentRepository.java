package com.hungdev.blog_app.repository;

import com.hungdev.blog_app.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
//    1. Method name
//    Prefix: findBy, countBy, deleteBy, existsBy

    // Select * from comment Where email = ?
    List<Comment> findByEmail(String email);

    List<Comment> findByIdGreaterThanEqualAndIdLessThanEqual(Long minId, Long maxId);

    Page<Comment> findByPostId(Long postId, Pageable pageable);

    //Delete from comment Where email = ?
    void deleteByEmail(String email);
//    2. Query

//    =============HQL(theo vị trí, theo tham số)

//    @Query("DELETE FROM Comment WHERE post.id = ?1") theo vị trí
//    void deleteAllByPostId(Long postId);

//    @Query("DELETE FROM Comment WHERE post.id = :postId") theo tham số (name parameter)
//    void deleteAllByPostId(@Param("postId") Long postId);

    //    ===============SQL
    @Query(value = "DELETE FROM Comment WHERE post_id = :postId", nativeQuery = true // phai them nay vo
    )
    @Modifying //Dùng nếu làm thay đổi dữ liệu trong DB
    @Transactional
//Nếu thành công thì thành công còn không thì rollback lại ban đầu, đảm bảo giao dịch an toàn
    void deleteAllByPostId(@Param("postId") Long postId);

}
