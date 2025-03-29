package albumapp.backend.controller.auth.dto;

// Response DTO
public record AuthResponseDto(
        String token,
        String username,
        String role
) {}
