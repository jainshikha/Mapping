package com.JPA.Mapping.repo;

import com.JPA.Mapping.entity.ComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * ComponentRepository
 */
@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, UUID> {

  /**
   * @param id
   * @return UUID
   */
  @Query(value = "select c.refComponentId from component c where c.id = :id")
  UUID getRefCompId(@Param("id") UUID id);

}
