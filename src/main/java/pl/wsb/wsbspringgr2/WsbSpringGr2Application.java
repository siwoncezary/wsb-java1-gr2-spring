package pl.wsb.wsbspringgr2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.wsb.wsbspringgr2.entity.TaskEntity;
import pl.wsb.wsbspringgr2.service.TodoService;

import java.time.LocalDate;

@SpringBootApplication
public class WsbSpringGr2Application implements CommandLineRunner {
	private final TodoService service;

	public WsbSpringGr2Application(TodoService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(WsbSpringGr2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TaskEntity entity = TaskEntity.builder()
				.email("email@op.pl")
				.title("testowe zadanie")
				.deadline(LocalDate.now())
				.done(false)
				.build();
		service.addTask(entity);
		service.addTask(TaskEntity.builder()
				.email("aaa@ws.pl")
				.title("testowe zadanie drugie")
				.deadline(LocalDate.of(2021, 10, 10))
				.build());
		service.addTask(TaskEntity.builder()
				.email("bbb@ws.pl")
				.title("testowe zadanie trzecie")
				.deadline(LocalDate.of(2021, 7, 10))
				.build());
		System.out.println(service.findAll());
	}
}
