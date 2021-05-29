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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-task-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String deadline = req.getParameter("deadline");
        String email = req.getParameter("email");
        TaskToDo todo = TaskToDo.builder().title(title).email(email).deadline(LocalDate.parse(deadline)).build();
        tasks.add(todo);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
