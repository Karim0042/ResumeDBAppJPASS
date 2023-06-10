package com.company;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.EmploymentHistoryServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResumeDbAppJpassApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpassApplication.class, args);
	}
	@Autowired
	private UserServiceInter userDao;
	@Autowired
	private EmploymentHistoryServiceInter emp;
	@Autowired
	private CountryServiceInter countryServiceInter;
	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr= new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				//User user = new User(null,"Karim2","Karimov2","kerim@gmail.com","+994708880780","233");
				//userDao.addUser(user);
				/*User user = new User(null,"Fazil","Karimov","fazil@gmail.com","+994708880780","2033");
				userDao.addUser(user);*/
				/*  User user = userDao.findByEmail("sr@gmail.com");
				System.out.println(user);*/
				//System.out.println(userDao.authorities(11).get(0).getName());
				/*List<Authority> list = userDao.authorities(14);
				String[] authorities = new String[list.size()];
				for (int i =0;i< list.size();i++){
			    	authorities[i] = list.get(i).getName();
				}
				for (int i =0;i< list.size();i++){
					System.out.println(authorities[i]);
				}*/
				/*EmploymentHistory employmentHistory =emp.getAllEmploymentHistoryByUserId(11).get(0);
				employmentHistory.setHeader("salam 33 yasim var");
				User u = userDao.getById(11);
				emp.updateEmpHistory(employmentHistory);*/
				//System.out.println(employmentHistory);
				//EmploymentHistory employmentHistory = new EmploymentHistory(null,"sadasd",,null,"dssd",u);
				//emp.addEmpHistory(employmentHistory);
				Country c = countryServiceInter.getCountryByName("USA");
				System.out.println(c);
			}
		};
		return clr;
	}
}
