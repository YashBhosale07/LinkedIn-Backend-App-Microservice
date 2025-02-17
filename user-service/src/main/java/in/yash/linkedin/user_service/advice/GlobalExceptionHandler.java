package in.yash.linkedin.user_service.advice;

import in.yash.linkedin.user_service.exception.BadRequestException;
import in.yash.linkedin.user_service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError>handleBadRequestException(BadRequestException badRequestException){
        ApiError apiError=ApiError.builder()
                .message(badRequestException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError>handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        ApiError apiError=ApiError.builder()
                .message(resourceNotFoundException.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }


}
