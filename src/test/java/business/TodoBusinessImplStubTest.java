package business;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void usingAStub(){

        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosToSpring("Ranga");
        assertEquals(2, todos.size());
    }
}
