package com.portfolio.about_me.Repository;

import com.portfolio.about_me.entity.ConnectMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectMeRepo extends JpaRepository<ConnectMe, Integer> {
}
