package albumapp.backend.controller.account.dto;

public record SignUpDto(
        String userName
        , String email
        , String password
) {
}
