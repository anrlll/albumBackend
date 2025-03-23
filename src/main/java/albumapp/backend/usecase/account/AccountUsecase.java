package albumapp.backend.usecase.account;

import albumapp.backend.controller.account.dto.SignUpDto;
import albumapp.backend.service.account.AccountService;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AccountUsecase {
    private final AccountService accountService;

    public AccountUsecase(AccountService accountService) {
        this.accountService = accountService;
    }

    public URI registerUser(SignUpDto dto){
        return accountService.registerUser(dto);
    }
}
