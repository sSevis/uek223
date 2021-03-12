package ch.noser.uek223.domain.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public User create(User entity) throws RuntimeException {

        Optional<User> optional = userRepository.findByEmail(entity.getEmail());

        if(optional.isPresent()) {
            throw new RuntimeException(String.format("%s with Email '%s' already exists", "User", entity.getEmail()));
        }

        entity.setId(null);

        entity.setPassword(encoder.encode(entity.getPassword()));

        entity = userRepository.saveAndFlush(entity);

        return entity;
    }

}
