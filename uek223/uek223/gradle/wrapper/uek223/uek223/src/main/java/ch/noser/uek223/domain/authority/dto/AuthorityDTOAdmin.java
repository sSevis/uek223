package ch.noser.uek223.domain.authority.dto;

import ch.noser.uek223.domain.role.Role;
import ch.noser.uek223.domain.role.dto.RoleDTOAdmin;

import java.util.Set;
import java.util.UUID;

public class AuthorityDTOAdmin {

   private UUID id;

   private String name;

    public AuthorityDTOAdmin(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorityDTOAdmin() {
    }

    public UUID getId() {
        return id;
    }

    public AuthorityDTOAdmin setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorityDTOAdmin setName(String name) {
        this.name = name;
        return this;
    }
}
