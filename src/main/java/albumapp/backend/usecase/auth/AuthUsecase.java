package albumapp.backend.usecase.auth;

import albumapp.backend.controller.auth.dto.AuthRequestDto;
import albumapp.backend.controller.auth.dto.AuthResponseDto;
import albumapp.backend.service.auth.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthUsecase {

    private final AuthService authService;

    public AuthUsecase(AuthService authService) {
        this.authService = authService;
    }

    public AuthResponseDto authenticate(AuthRequestDto authRequestDto) {
        return authService.authenticate(authRequestDto);
    }
}
