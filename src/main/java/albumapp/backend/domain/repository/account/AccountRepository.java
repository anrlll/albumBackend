package albumapp.backend.domain.repository.account;

import albumapp.backend.domain.model.account.AccountModel;
import albumapp.backend.mapper.account.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class AccountRepository {

    private final AccountMapper accountMapper;

    public AccountRepository(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * 新しいアカウントを登録する
     * @param accountModel アカウントモデル
     * @return URI　
     */
    public URI registerUser(AccountModel accountModel) {
        accountMapper.insertUser(accountModel);
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userName}")
                .buildAndExpand(accountModel.getUserName())
                .toUri();
    }
}
