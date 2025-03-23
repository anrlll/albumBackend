package albumapp.backend.mapper.account;

import albumapp.backend.domain.model.account.AccountModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM account WHERE username = #{userName}")
    AccountModel findByUsername(String username);

    @Select("SELECT * FROM account WHERE email = #{email}")
    AccountModel findByMEmail(String email);

    @Insert("INSERT INTO account (userName, email, password, role) VALUES (#{userName}, #{email}, #{password}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(AccountModel user);
}

