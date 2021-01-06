package business;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mock.*;
import org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

//mocking is creating objects that simulate the behavior of real objects
//UNLIke stubs, mocks can be dynamically created from code - at runtime
//Mocks offer more functionality than stubbing
//You can verify method calls and a lot of other things

public class TodoBusinessImplMockTest {

    @Test
    public void usingAMock(){

        //creating a Mock
        TodoService todoServiceMock = mock(TodoService.class); // creating a Mock
        //The stub equivalent = TodoService todoServiceStub = new TodoServiceStub();

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");

        //when: used to stub a method
        //thenReturn: return specific value
        //dynamically stubbing a method
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> todosBusImpl = todoBusinessImpl
                .retrieveTodosToSpring("Dummy");

        assertEquals(3, todos.size());
    }

    @Test
    public void withEmptyList(){

        //Stub = TodoService todoServiceStub = new TodoServiceStub();
        TodoService todoServiceMock = mock(TodoService.class); //Mock

        List<String> emptyList = new ArrayList<String>();

        //when: returns list of values
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(emptyList);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> todosBusImpl = todoBusinessImpl
                .retrieveTodosToSpring("Dummy");

        assertEquals(0, emptyList.size());
    }
}
