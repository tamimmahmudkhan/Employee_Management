package tests.model.staff;

import model.staff.EmployeeData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class EmployeeDataTest {


    private final String TEST_MAIL = "nomail";
    private final String TEST_PASSWD = "pewpew";
    private final String FNAME = "fname";
    private final String LNAME = "lname";
    private final String DOB = "dob";
    private final String POSITION = "position";


    EmployeeData SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new EmployeeData.Builder()
                .fname(FNAME)
                .lname(LNAME)
                .dob(DOB)
                .position(POSITION)
                .email(TEST_MAIL)
                .password(TEST_PASSWD)
                .build();
    }

    @Test
    public void getFname_fnameReturned() {
        String name = SUT.getFname();

        Assert.assertEquals(FNAME, name);
    }

    @Test
    public void getLname_lnameReturned() {
        String name = SUT.getLname();

        Assert.assertEquals(LNAME, name);
    }

    @Test
    public void getPosition_positionReturned() {
        String pos = SUT.getPosition();

        assertEquals(POSITION, pos);
    }

    @Test
    public void getDOB_dobReturned() {
        String pos = SUT.getDob();

        assertEquals(DOB, pos);
    }

    @Test
    public void getEmail_emailReturned() {
        String pos = SUT.getEmail();

        assertEquals(TEST_MAIL, pos);
    }
    @Test
    public void getPassword_passwordReturned() {
        String pos = SUT.getPassword();

        assertEquals(TEST_PASSWD, pos);
    }
}