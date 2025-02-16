package in.yash.linkedin.user_service.service.Impl;

import in.yash.linkedin.user_service.dto.SignUpRequestDto;
import in.yash.linkedin.user_service.dto.UserDto;
import in.yash.linkedin.user_service.entity.User;
import in.yash.linkedin.user_service.repository.AuthRepository;
import in.yash.linkedin.user_service.service.AuthService;
import in.yash.linkedin.user_service.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        User user=modelMapper.map(signUpRequestDto,User.class);
        user.setPassword(PasswordUtil.hashPassword(signUpRequestDto.getPassword())) ;
        User saved=authRepository.save(user);
        return modelMapper.map(saved, UserDto.class);
    }



}
