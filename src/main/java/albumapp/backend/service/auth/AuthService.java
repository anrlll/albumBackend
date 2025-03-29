package albumapp.backend.service.auth;

import albumapp.backend.controller.auth.dto.AuthRequestDto;
import albumapp.backend.controller.auth.dto.AuthResponseDto;
import albumapp.backend.domain.model.account.AccountModel;
import albumapp.backend.mapper.account.AccountMapper;
import albumapp.backend.security.jwt.JwtProvider;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final AccountMapper accountMapper;

    public AuthService(AuthenticationManager authenticationManager, JwtProvider jwtProvider, AccountMapper accountMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.accountMapper = accountMapper;
    }

    public AuthResponseDto authenticate(AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.username(),
                        authRequestDto.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authRequestDto.username());

        AccountModel account = accountMapper.findByUsername(authRequestDto.username());

        return new AuthResponseDto(jwt, account.getUserName(), account.getRole());
    }
}
