

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dal.Customer;
import dal.Vendor;

/**
 * Servlet implementation class MappingSer
 */
@WebServlet("/MappingSer")
public class MappingSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MappingSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//parent object
		Vendor v =new Vendor();
        v.setVendorid(102);
		v.setVendorname("JMB");
        Customer c1=new Customer();

		c1.setCustid(501);
		c1.setCustname("pawan");

		Customer c2=new Customer();

		c2.setCustid(502);
		c2.setCustname("amit");

		Customer c3=new Customer();

		c3.setCustid(503);
		c3.setCustname("hemant");

		// adding child objects to set, as we taken 3rd property set in parent
		Set s=new HashSet();

		s.add(c1);
		s.add(c2);
		s.add(c3);

		v.setChidren(s);

		Transaction tx = session.beginTransaction();

		session.save(v);

		tx.commit();
		session.close();
		PrintWriter out = response.getWriter();
		out.println("One To Many is Done..!!");
		factory.close();
	}

}
