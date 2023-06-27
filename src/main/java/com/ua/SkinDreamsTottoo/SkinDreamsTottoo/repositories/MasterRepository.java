package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

    Master findMasterByName(String name);
}
