package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    Blog findByTitle(String title);

    void deleteByTitle(String title);

}
