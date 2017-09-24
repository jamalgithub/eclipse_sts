package np.com.mshrestha.bookstore.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/Bean.xml");
		PasswordEncoder passwordEncoder = (PasswordEncoder) context.getBean("passwordEncoder");
		String encodedPassword = passwordEncoder.encodePassword("admin","adm1234hghghghghg*");
		System.out.println(encodedPassword);
	}

}
