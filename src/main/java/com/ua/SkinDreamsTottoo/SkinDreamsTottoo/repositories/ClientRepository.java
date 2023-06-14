package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
