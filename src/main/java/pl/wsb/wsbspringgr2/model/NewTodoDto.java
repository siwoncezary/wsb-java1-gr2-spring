package pl.wsb.wsbspringgr2.model;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class NewTodoDto {
    @NotNull(message = "Tytuł nie może być pusty!")
    @Length(min = 5, message = "Tytuł jest za krótki, co najmniej 5 znaków")
    private String title;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @NotNull
    @Email(message = "Niepoprawny email!")
    private String email;
}
