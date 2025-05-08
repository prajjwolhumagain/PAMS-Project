
public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {
        String newTime = appointment.appointmentTime.trim();
        if (root == null) {
            appointment.appointmentTime = newTime;
            return new AppointmentNode(appointment);
        }
        String currentTime = root.data.appointmentTime.trim();
        int comparison = newTime.compareTo(currentTime);

        if (comparison < 0) {
            root.left = insertRec(root.left, appointment);
        } else if (comparison > 0) {
            root.right = insertRec(root.right, appointment);
        } else {
            // Duplicate found
            System.out.println("Duplicate appointment time: " + newTime);
        }
        return root;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}
