package org.example.arapp.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.arapp.domain.App;
import org.example.arapp.domain.Group;
import org.example.arapp.dto.groupdto.GroupDto;
import org.example.arapp.exception.AppNotFoundException;
import org.example.arapp.exception.GroupNameAlreadyExistsException;
import org.example.arapp.repo.AppRepository;
import org.example.arapp.repo.GroupRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final AppRepository appRepository;

    public Group save(GroupDto groupDto) {
        Optional<App> app = appRepository.findById(groupDto.getAppID());
        if (app.isEmpty()) {
            throw new AppNotFoundException(groupDto.getAppID());
        }
        List<Group> groupsByAppIdAndName = groupRepository.findGroupsByAppIdAndName(groupDto.getAppID(), groupDto.getName());
        Optional<Group> first = groupsByAppIdAndName.stream().filter(group -> group.getName().equalsIgnoreCase(groupDto.getName())).findFirst();
        if (first.isPresent()) {
            throw new GroupNameAlreadyExistsException(app.get().getName());
        }
        return groupRepository.save(Group.builder().name(groupDto.getName()).app(app.get()).build());
    }
}
