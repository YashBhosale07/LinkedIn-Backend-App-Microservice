package in.yash.linkedin.posts_service.Advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String message;
    private LocalDateTime localDateTime;
    private HttpStatus httpStatus;
}
