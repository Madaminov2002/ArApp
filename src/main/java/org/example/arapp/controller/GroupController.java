package org.example.arapp.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.Group;
import org.example.arapp.dto.groupdto.GrUpdateDto;
import org.example.arapp.dto.groupdto.GroupDto;
import org.example.arapp.repo.GroupRepository;
import org.example.arapp.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupRepository groupRepository;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupService.save(groupDto));
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Group>> showAll() {
        return ResponseEntity.ok(groupRepository.findAll());
    }

    @PutMapping("/update-group-status")
    public ResponseEntity<String> updateGroupStatus(@RequestBody GrUpdateDto dto) {
        groupService.updateGroupStatus(dto);
        return ResponseEntity.ok("Group status updated");
    }

}
