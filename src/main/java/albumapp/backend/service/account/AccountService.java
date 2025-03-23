package albumapp.backend.service.account;

import albumapp.backend.controller.account.dto.SignUpDto;
import albumapp.backend.domain.model.account.AccountModel;
import albumapp.backend.domain.repository.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public URI registerUser(SignUpDto dto){
        //TODO PWを暗号化する security周りが関わってくるので認証のところで一緒にやる
        var userModel = AccountModel.generalUser(
                dto.userName()
                , dto.email()
                , dto.password()
        );
        return accountRepository.registerUser(userModel);
    }
}