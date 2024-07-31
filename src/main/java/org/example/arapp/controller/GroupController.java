package org.example.arapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.Group;
import org.example.arapp.dto.groupdto.GroupDto;
import org.example.arapp.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/save")
    public ResponseEntity<Group> save(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupService.save(groupDto));
    }
}
