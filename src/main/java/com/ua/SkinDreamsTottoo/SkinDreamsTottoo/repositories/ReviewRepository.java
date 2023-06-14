package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
