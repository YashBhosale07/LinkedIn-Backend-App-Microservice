package in.yash.linkedin.user_service.service.Impl;

import in.yash.linkedin.user_service.dto.SignUpRequestDto;
import in.yash.linkedin.user_service.dto.UserDto;
import in.yash.linkedin.user_service.dto.loginRequestDto;
import in.yash.linkedin.user_service.entity.User;
import in.yash.linkedin.user_service.exception.BadRequestException;
import in.yash.linkedin.user_service.exception.ResourceNotFoundException;
import in.yash.linkedin.user_service.repository.UserRepository;
import in.yash.linkedin.user_service.service.AuthService;
import in.yash.linkedin.user_service.service.JwtService;
import in.yash.linkedin.user_service.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    @Override
    public UserDto signUp(SignUpRequestDto signUpRequestDto) {
        boolean exitsEmail=userRepository.existsByEmail(signUpRequestDto.getEmail());
        if(exitsEmail){
            throw new BadRequestException("Email already exists....try with another email..");
        }
        User user=modelMapper.map(signUpRequestDto,User.class);
        user.setPassword(PasswordUtil.hashPassword(signUpRequestDto.getPassword())) ;
        User saved=userRepository.save(user);
        return modelMapper.map(saved, UserDto.class);
    }

    @Override
    public String login(loginRequestDto loginRequestDto) {
        User user=userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("User not found with email "+loginRequestDto.getEmail()));
        boolean isPasswordMatch=PasswordUtil.checkPassword(loginRequestDto.getPassword(),user.getPassword());
        if(!isPasswordMatch){
            throw new BadRequestException("Incorrect Password");
        }
        return jwtService.generateJwtToken(user);
    }


}
