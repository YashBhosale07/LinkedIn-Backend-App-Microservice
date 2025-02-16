package in.yash.linkedin.user_service.dto;

import lombok.Data;

@Data
public class loginRequestDto {
    private String email;
    private String password;
}
