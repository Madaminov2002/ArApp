package org.example.arapp.repo;

import java.util.List;
import org.example.arapp.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupsByAppIdAndName(Long appId, String name);

    List<Group> findGroupsByAppId(Long appId);
}