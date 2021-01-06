package business;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class ListTest {

    @Test
    public void letsMockListSize(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSizeMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet1(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("in28minutes");

        assertEquals("in28minutes", listMock.get(0));
        assertEquals(null, listMock.get(1));

    }

    @Test
    public void letsMockListGet2(){
        List listMock = mock(List.class);

        //Argument Matcher - only there to avoid casting
        //Mockito class extends Matchers class
        when(listMock.get(anyInt())).thenReturn("in28minutes");

        assertEquals("in28minutes", listMock.get(0));
        assertEquals("in28minutes", listMock.get(1));

    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGetThrowException(){
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("This is an exception"));

       listMock.get(0);

    }
}
