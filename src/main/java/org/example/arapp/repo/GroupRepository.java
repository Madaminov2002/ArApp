package org.example.arapp.repo;

import java.util.List;
import java.util.Optional;

import org.example.arapp.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupsByAppIdAndName(Long appId, String name);

    List<Group> findGroupsByAppId(Long appId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update groups set active=false where name=:grName and app_id=:appId")
    void updateStatusToFalse(@Param("grName") String grName, @Param("appId") Long appId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update groups set active=true where name=:grName and app_id=:appId")
    void updateStatusToTrue(@Param("grName") String grName, @Param("appId") Long appId);

    Optional<Group> findByNameAndApp_Name(String groupName, String appName);
}