import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	private static List<Student> sortStudent(List<Student> student){
		Collections.sort(student, new StudentComparator());
		return student;
	}
	private static void display(List<Student> students) {
	    if (students.isEmpty()) {
	        System.err.println("Empty list");
	        return;
	    }
	    for (int i = 0; i < students.size(); i++) {
	        System.out.println("----- Student " + (i + 1) + " -----");
	        System.out.println("Name: " + capitalize(students.get(i).getName()));
	        System.out.println("Classes: " + students.get(i).getClasses());
	        System.out.println("Mark: " + students.get(i).getMark());
	    }
	}
	private static String capitalize(String name) {
		if( name == null || name.isEmpty()) {
			return name;
		}
		return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
	}

	private static boolean checkInputYN() {
		while(true) {
			String in = sc.nextLine().trim();
			if(in.length() == 1 && in.equalsIgnoreCase("Y")){
				return true;
			}
			else if(in.length() == 1 && in.equalsIgnoreCase("N")) {
				return false;
			}
			System.out.print("Try again: ");
		}
	}
	private static String checkInputString() {
	    while (true) {
	        String in = sc.nextLine().trim();
	        if (in.length() == 0) {
	            System.err.println("Cannot be empty. Try again.");
	            continue;
	        }
	        return in;
	    }
	}

	private static float checkInputFloat() {
	    while (true) {
	        try {
	            float in = Float.parseFloat(sc.nextLine().trim());
	            if (in >= 0 && in <= 100) {
	                return in;
	            } else {
	                System.err.println("Mark must be between 0 and 100. Try again.");
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid number. Try again.");
	        }
	    }
	}
	private static String checkInputClass() {
	    while (true) {
	        String in = sc.nextLine().trim();
	        if (in.matches("FU\\d{2}")) {  
	            return in;
	        } else {
	            System.err.println("Invalid format! Class must be in the format 'FUxx' (e.g., FU12).");
	            
	        }
	        System.out.print("Try again: ");
	    }
	}


	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		while(true) {
			System.out.println("===== Collection Sort Program =====");
			System.out.println("Please input student information");
			System.out.print("Name: ");
			String name = checkInputString();
			System.out.print("Classes: ");
			String classes = checkInputClass();
			System.out.print("Mark: ");
			float mark = checkInputFloat();
			students.add(new Student(name, mark, classes));
			 System.out.print("Do you want to enter more student information? (Y/N): ");
	            if (!checkInputYN()) {
	                break;
	            }
		}
		
		sortStudent(students);
        display(students);
		

	}

}
