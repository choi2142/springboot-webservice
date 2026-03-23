package com.choi.springwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface PostsRepostitory extends JpaRepository<Posts, Long>{
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();  

    @Query("SELECT p " +
            "FROM Posts p " +
            "where p.id = ?1")
    Posts findDetail(Long id);

    @Query("SELECT COUNT(p) FROM Posts p WHERE p.isDeleted = false")
    long countByIsDeletedFalse();

    @Query("SELECT p FROM Posts p WHERE p.isDeleted = false AND (:author IS NULL OR p.author = :author)")
    List<Posts> findAllByAuthorAndNotDeleted(@Param("author") String author);
}