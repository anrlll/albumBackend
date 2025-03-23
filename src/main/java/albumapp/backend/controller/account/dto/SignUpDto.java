package albumapp.backend.controller.account.dto;

public record SignUpDto(
        String userName
        , String email
        , String password
        // TODO 暗号化されたPWを受け取ってService層でデコードしたい
) {
}
