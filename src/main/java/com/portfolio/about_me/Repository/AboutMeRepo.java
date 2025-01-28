package com.portfolio.about_me.Repository;
import com.portfolio.about_me.entity.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepo extends JpaRepository<AboutMe, Integer> {
}
