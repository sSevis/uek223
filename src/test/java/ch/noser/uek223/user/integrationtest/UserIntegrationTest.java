package ch.noser.uek223.user.integrationtest;

import ch.noser.uek223.domain.authority.Authority;
import ch.noser.uek223.domain.authority.AuthorityRepository;
import ch.noser.uek223.domain.authority.dto.AuthorityDTOAdmin;
import ch.noser.uek223.domain.role.Role;
import ch.noser.uek223.domain.role.RoleRepository;
import ch.noser.uek223.domain.role.dto.RoleDTOAdmin;
import ch.noser.uek223.domain.user.User;
import ch.noser.uek223.domain.user.UserRepository;
import ch.noser.uek223.domain.user.dto.UserDTOAdmin;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class UserIntegrationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private MockMvc mvc;
    @BeforeEach
    public void setUp(){}
    @WithMockUser
    @Test
    public void findById_requestUserById_returnsUser() throws Exception {
        UUID uuidToBeTestedAgainst = UUID.randomUUID();
        Set<Authority> authoritiesToBeTestedAgainst = Stream.of(new Authority().setName("USER_SEE"), new Authority().setName("USER_CREATE"), new Authority().setName("USER_MODIFY"), new Authority().setName("USER_DELETE")).collect(Collectors.toSet());
        Set<Role> rolesToBeTestedAgainst = Stream.of(new Role().setName("BASIC_USER").setAuthorities(authoritiesToBeTestedAgainst)).collect(Collectors.toSet());
        User userToBeTestedAgainst = new User().setFirstName("John").setSurname("Doe").setEmail("john.doe@noseryoung.ch").setPassword(new BCryptPasswordEncoder().encode(uuidToBeTestedAgainst.randomUUID().toString())).setRoles(rolesToBeTestedAgainst);
        authoritiesToBeTestedAgainst.forEach(authority -> authorityRepository.save(authority));
        rolesToBeTestedAgainst.forEach(role -> roleRepository.save(role));
        userRepository.save(userToBeTestedAgainst);
        Set<AuthorityDTOAdmin> authorityDTOSToBeTestedAgainst = Stream.of(new AuthorityDTOAdmin().setName("USER_SEE"), new AuthorityDTOAdmin().setName("USER_CREATE"), new AuthorityDTOAdmin().setName("USER_MODIFY"), new AuthorityDTOAdmin().setName("USER_DELETE")).collect(Collectors.toSet());
        Set<RoleDTOAdmin> roleDTOSToBeTestedAgainst = Stream.of(new RoleDTOAdmin().setName("BASIC_USER").setAuthorities(authorityDTOSToBeTestedAgainst)).collect(Collectors.toSet());
        UserDTOAdmin userDTOToBeTestedAgainst = new UserDTOAdmin(userToBeTestedAgainst.getId(), userToBeTestedAgainst.getEmail(), userToBeTestedAgainst.getFirstName(), userToBeTestedAgainst.getSurname(), userToBeTestedAgainst.getPassword(), null).setFirstName("John").setSurname("Doe").setEmail("john.doe@noseryoung.ch").setRoles(roleDTOSToBeTestedAgainst);
        mvc.perform(
                MockMvcRequestBuilders.get("/users/{id}", userDTOToBeTestedAgainst.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userDTOToBeTestedAgainst.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(userDTOToBeTestedAgainst.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value(userDTOToBeTestedAgainst.getSurname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(userDTOToBeTestedAgainst.getEmail()));

                //.andExpect(MockMvcResultMatchers.jsonPath("$.roles[*]").value(userDTOToBeTestedAgainst.getRoleDTOAdmin().toArray()))    //.value(Matchers.containsInAnyOrder(userDTOToBeTestedAgainst.getRoleDTOAdmin().stream().map(RoleDTOAdmin::getName).toArray())))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.roles[*].authorities[*]").value(Matchers.containsInAnyOrder(userDTOToBeTestedAgainst.getRoleDTOAdmin().stream().map(RoleDTOAdmin::getAuthorities).flatMap(Collection::stream).map(AuthorityDTOAdmin::getName).toArray())));
    }
}
