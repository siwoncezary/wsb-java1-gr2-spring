package pl.wsb.wsbspringgr2.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaskToDo {
    private String title;
    private LocalDate deadline;
    private String email;
    private boolean done;
}
