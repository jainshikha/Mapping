package com.JPA.Mapping.repo;

import com.JPA.Mapping.entity.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * TrackRepository
 */
@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, UUID> {

  @Query(value = "select t from track t where t.name = :name")
  TrackEntity fetchTrackByName(@Param("name") String name);
}
