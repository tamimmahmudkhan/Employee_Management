package tests.model.staff;


import model.staff.EmployeeData;
import model.staff.StaffManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StaffManagerTest {

    StaffManager SUT;
    EmployeeData testData;

    private final String TEST_MAIL = "nomail";
    private final String TEST_PASSWD = "pewpew";
    private final String FNAME = "fname";
    private final String LNAME = "lname";
    private final String DOB = "dob";
    private final String POSITION = "position";


    @Before
    public void setUp() throws Exception {
        SUT = new StaffManager();

        testData = getData();
    }

    private EmployeeData getData() {
        return new EmployeeData.Builder()
                .fname(FNAME)
                .lname(LNAME)
                .dob(DOB)
                .position(POSITION)
                .email(TEST_MAIL)
                .password(TEST_PASSWD)
                .build();
    }

    @Test
    public void checkEmployee_validInput_trueReturned() {
        boolean checkEmployee = SUT.checkEmployee(TEST_MAIL, TEST_PASSWD);

        Assert.assertTrue(checkEmployee);
    }

    @Test
    public void checkEmployee_invalidInput_falseReturned() {
        boolean check = SUT.checkEmployee("invalid mail", "invalid passwd");

        Assert.assertFalse(check);
    }

    @Test
    public void addEmployee_trueReturned() {
        boolean check = SUT.addEmployee(testData);

        Assert.assertTrue(check);
    }

    @Test
    public void removeEmployee_validInput() {
        SUT.addEmployee(testData);

        boolean removeEmployee = SUT.removeEmployee(testData);

        Assert.assertTrue(removeEmployee);
    }

    @After
    public void tearDown() throws Exception {
        if (SUT.checkEmployee(testData.getEmail(), testData.getPassword())) {
            SUT.removeEmployee(testData);
        }
    }
}