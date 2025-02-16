package in.yash.linkedin.user_service.service;

import in.yash.linkedin.user_service.dto.SignUpRequestDto;
import in.yash.linkedin.user_service.dto.UserDto;

public interface AuthService {
    UserDto signUp(SignUpRequestDto signUpRequestDto);
}
