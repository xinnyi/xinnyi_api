package ch.course223.advanced.domainmodels.user;

import ch.course223.advanced.core.ExtendedJpaRepository;
import ch.course223.advanced.core.ExtendedServiceImpl;
import ch.course223.advanced.domainmodels.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService{

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(ExtendedJpaRepository<User> repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return new UserDetailsImpl(findByEmail(email));
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
    @Override
    public User findByEmail(String email) {
        return findOrThrow(((UserRepository)repository).findByEmail(email));
    }

    @Override
    public User findByDevices(String messengerId) {
        List<User> userList = ((UserRepository)repository).findAll();
        for (User user : userList) {
            List<Device> deviceList = user.getDevices();
            for (Device device : deviceList) {
                String msgId = device.getMessengerID();
                if (msgId == messengerId){
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public User save(User user){
        user.setEnabled(true).setLocked(false).setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ((UserRepository)repository).save(user);
    }


}
