package pl.wsb.wsbspringgr2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskToDo {
    private String title;
    private LocalDate deadline;
    private String email;
    private boolean done;
}
