package com.prahlad.study.splitwise.service;

import com.prahlad.study.splitwise.models.Group;
import com.prahlad.study.splitwise.models.User;
import com.prahlad.study.splitwise.repository.GroupRepository;
import com.prahlad.study.splitwise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public Group addGroup(final String groupName) {
        return groupRepository.save(Group.builder().name(groupName).build());
    }

    public Group addMember(final Long groupId, final Long memberId) {

        User user = userRepository.getById(memberId);
        Group group = groupRepository.getById(groupId);
        group.getMembers().add(user);
        return groupRepository.save(group);
    }




}
