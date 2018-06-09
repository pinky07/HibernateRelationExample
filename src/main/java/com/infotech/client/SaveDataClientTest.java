package com.infotech.client;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Phone;
import com.infotech.entities.Student;
import com.infotech.entities.User;
import com.infotech.entities.UserProfile;
import com.infotech.util.HibernateUtil;
import com.infotech.entities.Course;
import com.infotech.entities.Gender;
import com.infotech.entities.Name;
public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
//	    	Employee employee= new Employee();
//			employee.setEmployeeName("Barry Bingel");
//			employee.setEmail("barry.cs2017@gmail.com");
//			employee.setSalary(50000.00);
//			employee.setDoj(new Date());
//			
//			Address address1 = new Address();
//			address1.setCity("Chennai");
//			address1.setPincode(9087727L);
//			address1.setState("Tamilnadu");
//			address1.setStreet("Park Street");
//			
//			Address address2 = new Address();
//			address2.setCity("Pube");
//			address2.setPincode(9000027L);
//			address2.setState("MH");
//			address2.setStreet("XYZ Street");
			
//			employee.getAddressList().add(address1);
//			//employee.getAddressList().add(address2);
//			session.persist(employee);
//			
			//session.getTransaction().commit();
			User user = new User();
			user.setName("Pinky2");
			
			Phone phone = new Phone();
			phone.setBrand("nokia");
			phone.setModel("800");
			phone.setBrand("nokia2");
			phone.setModel("8002");
			phone.setUser(user);
			session.persist(phone);
//			user.getPhone().add(phone);
			
//			session.persist(user);
			//session.getTransaction().commit();
			
//			Calendar dateOfBirth = Calendar.getInstance();
//	        dateOfBirth.set(1992, 7, 21);
//			
//			UserProfile userProfile = new UserProfile();
//			userProfile.setDateOfBirth(dateOfBirth.getTime());
//			userProfile.setGender(Gender.FEMALE);
//			userProfile.setPhoneNumber("9827130222");
//			
//			userProfile.setUser(user);
//			session.persist(userProfile);
//			session.getTransaction().commit();

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("computer science"));
			courses.add(new Course("Math"));
			Student student1 = new Student("Pinky",courses);
			Student student2 = new Student("Joe", courses);
			student1.setPhoneNumber("842352888");
			
			session.persist(student1);
			session.save(student2);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
