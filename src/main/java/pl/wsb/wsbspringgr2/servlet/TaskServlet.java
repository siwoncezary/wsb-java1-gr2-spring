package pl.wsb.wsbspringgr2.servlet;

import pl.wsb.wsbspringgr2.model.TaskToDo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private List<TaskToDo> tasks = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        tasks.add(TaskToDo.builder().title("Zadanie 1").email("email1@op.pl").deadline(LocalDate.now()).build());
        tasks.add(TaskToDo.builder().title("Zadanie 2").email("email3@op.pl").deadline(LocalDate.now()).build());
        tasks.add(TaskToDo.builder().title("Zadanie 3").email("email2@op.pl").deadline(LocalDate.of(2021, 5, 30)).build());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().endsWith("/list")){
            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("/WEB-INF/list-task.jsp").forward(req, resp);
            return;
        }
        if (req.getRequestURI().endsWith("/add")) {
            req.getRequestDispatcher("/WEB-INF/add-task-form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST " + req.getRequestURI());
        if(req.getRequestURI().endsWith("/done")){
            System.out.println("DONE");
            String doneTask = req.getParameter("done");
            if (doneTask != null){
                int index = Integer.parseInt(doneTask);
                tasks.get(index).setDone(true);
            }
            resp.sendRedirect("/todo/list");
        }
        if (req.getRequestURI().endsWith("/add")) {
            String title = req.getParameter("title");
            String deadline = req.getParameter("deadline");
            String email = req.getParameter("email");
            if (title == null || deadline == null || email == null) {
                return;
            }
            TaskToDo todo = TaskToDo.builder().title(title).email(email).deadline(LocalDate.parse(deadline)).build();
            tasks.add(todo);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.sendRedirect("/todo/list");
        }
    }
}
