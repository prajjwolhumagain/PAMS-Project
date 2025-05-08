import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentBSTTest {

    @Test
    public void testAddAppointment() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        bst.addAppointment(p1);
        assertNotNull(bst.getRoot());
        assertEquals("09:00", bst.getRoot().data.appointmentTime);
    }

    @Test
    public void testAddMultipleAppointments() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "Adrian", "09:00"));
        bst.addAppointment(new PatientAppointment(2, "Ben", "10:00"));
        bst.addAppointment(new PatientAppointment(3, "Charlie", "08:00"));

        AppointmentNode root = bst.getRoot();
        assertEquals("09:00", root.data.appointmentTime);
        assertEquals("08:00", root.left.data.appointmentTime);
        assertEquals("10:00", root.right.data.appointmentTime);
    }

    @Test
    public void testDuplicateAppointmentTimeIsNotInserted() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "Adrian", "09:00"));
        bst.addAppointment(new PatientAppointment(2, "Ben", "09:00"));  // Duplicate

        AppointmentNode root = bst.getRoot();
        assertEquals("09:00", root.data.appointmentTime);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testTrimmedTimeIsHandledAsDuplicate() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "Adrian", " 09:00 "));
        bst.addAppointment(new PatientAppointment(2, "Ben", "09:00"));  // Treated as duplicate

        AppointmentNode root = bst.getRoot();
        assertEquals("09:00", root.data.appointmentTime.trim());
        assertNull(root.left);
        assertNull(root.right);
    }
}