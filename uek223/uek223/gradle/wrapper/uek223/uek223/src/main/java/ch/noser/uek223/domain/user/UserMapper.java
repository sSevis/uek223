package ch.noser.uek223.domain.user;

import ch.noser.uek223.domain.user.dto.UserDTOAdmin;
import ch.noser.uek223.domain.user.dto.UserDTONew;
import ch.noser.uek223.domain.user.dto.UserDTOSupplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTOSupplier userToUserDTOSupplier(User user);

    UserDTOAdmin userToUserDTOAdmin(User user);

    List<UserDTOAdmin> usersToUserDTOAdmin(List<User> users);

    User userDTONewToUser(UserDTONew userDTONew);
}
