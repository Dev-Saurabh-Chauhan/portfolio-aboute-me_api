package com.portfolio.about_me.Repository;

import com.portfolio.about_me.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Documents,Integer> {
}
