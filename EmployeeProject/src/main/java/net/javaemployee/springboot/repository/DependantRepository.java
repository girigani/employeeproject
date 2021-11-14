package net.javaemployee.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaemployee.springboot.model.Dependant;


@Repository
public interface DependantRepository extends JpaRepository<Dependant, Long> {

}
