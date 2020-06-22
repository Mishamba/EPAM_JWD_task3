package mishamba.day3.service.session;

import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.service.session.SessionService;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SessionServiceTest {

    @Test(groups = "main")
    public void start_noException() {
        SessionService service = new SessionService();
        try {
            service.start();
        } catch (ProgramException ex) {
            fail("got exception");
        }
    }
}