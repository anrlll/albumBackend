package albumapp.backend.service.account;

import albumapp.backend.controller.account.dto.SignUpDto;
import albumapp.backend.domain.model.account.AccountModel;
import albumapp.backend.domain.repository.account.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public URI registerUser(SignUpDto dto){
        //TODO PWを暗号化する security周りが関わってくるので認証のところで一緒にやる
        var userModel = AccountModel.generalUser(
                dto.userName()
                , dto.email()
                , passwordEncoder.encode(dto.password())
        );
        return accountRepository.registerUser(userModel);
    }
}