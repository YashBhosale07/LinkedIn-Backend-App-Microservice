package in.yash.linkedin.user_service.service;

import in.yash.linkedin.user_service.dto.SignUpRequestDto;
import in.yash.linkedin.user_service.dto.UserDto;
import in.yash.linkedin.user_service.dto.loginRequestDto;

public interface AuthService {
    UserDto signUp(SignUpRequestDto signUpRequestDto);

    String login(loginRequestDto loginRequestDto);
}
