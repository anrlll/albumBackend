package albumapp.backend.service.auth;

import albumapp.backend.domain.model.account.AccountModel;
import albumapp.backend.mapper.account.AccountMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

//TODO 後でUserDetailsServiceImplを名前変更する
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountMapper accountMapper;

    public UserDetailsServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel account = accountMapper.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new User(account.getUserName(),
                account.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
    }
}