package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role role);
}
