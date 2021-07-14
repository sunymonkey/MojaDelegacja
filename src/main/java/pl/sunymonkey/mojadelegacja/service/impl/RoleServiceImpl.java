package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.Role;
import pl.sunymonkey.mojadelegacja.repository.RoleRepository;
import pl.sunymonkey.mojadelegacja.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
