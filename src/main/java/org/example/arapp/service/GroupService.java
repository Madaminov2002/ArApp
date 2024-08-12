package org.example.arapp.service;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.arapp.dto.groupdto.AppAndGroupForGetQrsReqDto;
import org.example.arapp.domain.App;
import org.example.arapp.domain.Group;
import org.example.arapp.domain.QrCode;
import org.example.arapp.dto.groupdto.GrUpdateDto;
import org.example.arapp.dto.groupdto.GroupDto;
import org.example.arapp.exception.AppNotFoundException;
import org.example.arapp.exception.GroupNameAlreadyExistsException;
import org.example.arapp.exception.GroupNotFoundException;
import org.example.arapp.projection.QrProjection;
import org.example.arapp.repo.AppRepository;
import org.example.arapp.repo.GroupRepository;
import org.example.arapp.repo.QrCodeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final AppRepository appRepository;
    private final QrCodeRepository qrCodeRepository;

    public String save(GroupDto groupDto) {
        Optional<App> app = appRepository.findById(groupDto.getAppID());
        if (app.isEmpty()) {
            throw new AppNotFoundException(String.valueOf(groupDto.getAppID()));
        }
        List<Group> groupsByAppIdAndName = groupRepository.findGroupsByAppIdAndName(groupDto.getAppID(), groupDto.getName());
        Optional<Group> first = groupsByAppIdAndName.stream().filter(group -> group.getName().equalsIgnoreCase(groupDto.getName())).findFirst();
        if (first.isPresent()) {
            throw new GroupNameAlreadyExistsException(app.get().getName());
        }

        groupRepository.save(Group.builder().name(groupDto.getName()).app(app.get()).build());

        return "Group created";
    }

    public void updateGroupStatus(GrUpdateDto dto) {
        Optional<App> app = appRepository.findByName(dto.getAppName());
        if (app.isEmpty()) {
            throw new AppNotFoundException(dto.getAppName());
        }
        if (dto.getStatus().equalsIgnoreCase("false")) {
            groupRepository.updateStatusToFalse(dto.getGrName(), app.get().getId());
        }

        if (dto.getStatus().equalsIgnoreCase("true")) {
            groupRepository.updateStatusToTrue(dto.getGrName(), app.get().getId());
        }
    }

    public List<QrProjection> getQrsOfGroup(@Valid AppAndGroupForGetQrsReqDto appAndGroupForGetQrsReqDto) {

        var groupOptional = groupRepository.findByNameAndApp_Name(appAndGroupForGetQrsReqDto.getGroupName(), appAndGroupForGetQrsReqDto.getAppName());

        if (groupOptional.isEmpty()) {
            throw new GroupNotFoundException(appAndGroupForGetQrsReqDto.getGroupName());
        }


        List<QrProjection> qrProjectionList = qrCodeRepository.findByAppAndGroupName(appAndGroupForGetQrsReqDto.getAppName(), appAndGroupForGetQrsReqDto.getGroupName());

        return qrProjectionList;


    }
}
