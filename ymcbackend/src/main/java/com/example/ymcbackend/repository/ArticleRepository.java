package com.example.ymcbackend.repository;

import com.example.ymcbackend.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
