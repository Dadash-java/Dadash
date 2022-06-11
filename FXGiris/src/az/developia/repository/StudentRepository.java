package az.developia.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import az.developia.Student;

public class StudentRepository {

	public List<Student> findAllStudents() {
		List<Student> list=new ArrayList<Student> ();
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java3_fx_t",
		"root","1234");
			
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from students");
			while(rs.next()) {
				Student	 s=new Student
						(rs.getString("name"),rs.getString ("surname"));
				list.add(s); 
			}
		
			st.close();
			c.close();
		}catch (Exception e) {
			System.out.println(e);
			
		}
		return list;
	}

	public void saveStudentToDatabase(Student s) {
		
		
	}


	}

		
	}
		