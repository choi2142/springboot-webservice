package com.choi.springwebservice.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface PostsRepostitory extends JpaRepository<Posts, Long>{
	@Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
	
	List<Posts> findBoardByContent(String content);
    // id > ? ORDER BY id DESC limit ?, ?
	List<Posts> findByIdGreaterThanOrderByIdDesc(Long id, Pageable paging);
    // id > ? limit ?, ?
    Page<Posts> findByIdGreaterThan(Long id, Pageable paging);

    @Query(value = "select * from Posts b where b.author like %?1%", nativeQuery = true)
    List<Posts> findBoardByUsername(String author);
	
}
