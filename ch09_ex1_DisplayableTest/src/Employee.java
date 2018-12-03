public class Employee implements Displayable, DepartmentConstants {

    private int department;
    private String firstName;
    private String lastName;

    public Employee(int department, String lastName, String firstName) {
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
    }

	@Override
	public String toString() {
		String textString = firstName + " " + lastName + " (";
		if (department == ADMIN) {
			textString += "Administration)";
		} else if (department == EDITORIAL) {
			textString += "Editorial)";
		} else if (department == MARKETING) {
			textString += "Marketing)";
		}
		return textString;
	}
}