package albumapp.backend.controller.account;

import albumapp.backend.controller.account.dto.SignUpDto;
import org.springframework.web.bind.annotation.RestController;

import albumapp.backend.usecase.account.AccountUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    //TODO created_atとか色々足りてないカラムがあるから、SQLに記載しなくてもそれらのカラムは作成されるように設定する Flywayにある気がする
    private final AccountUsecase accountUsecase;

    public AccountController(AccountUsecase accountUsecase) {
        this.accountUsecase = accountUsecase;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto dto) {
        var res = accountUsecase.registerUser(dto);
        return ResponseEntity.created(res).build();
    }
}
