package in.yash.linkedin.posts_service.Advice;
import in.yash.linkedin.posts_service.Exception.BadRequestException;
import in.yash.linkedin.posts_service.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError>handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        ApiError apiError=new ApiError(resourceNotFoundException.getMessage()
                , LocalDateTime.now(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError>handleBadRequestException(BadRequestException badRequestException){
        ApiError apiError=new ApiError(badRequestException.getMessage()
                , LocalDateTime.now(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

    }

}
