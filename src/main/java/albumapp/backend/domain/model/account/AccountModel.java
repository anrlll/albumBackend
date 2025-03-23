package albumapp.backend.domain.model.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountModel {
    private String id;
    private String userName;
    private String email;
    private String password;
    private String role;

    public static AccountModel generalUser(String userName, String email, String password) {
        var account = new AccountModel();
        account.setUserName(userName);
        account.setEmail(email);
        account.setPassword(password);
        account.setRole("GENERAL_USER"); //TODO roleのenumのvalueObjectを作って置き換える
        return account;
    }
}
