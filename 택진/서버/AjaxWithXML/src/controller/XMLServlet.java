package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import domain.Customer;
import domain.Wrapper;

@WebServlet("/getCustomer.do")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/xml;charset=utf-8");
	OutputStream out = response.getOutputStream();
	
	Customer cus1 = new Customer();
	cus1.setId("1234");
	cus1.setPassword("0000");
	cus1.setName("택진");
	cus1.setAddress("서울시 마포구");
	
	
	Customer cus2 = new Customer();
	cus2.setId("1234");
	cus2.setPassword("0000");
	cus2.setName("택진");
	cus2.setAddress("서울시 마포구");
	
	List<Customer> list = new ArrayList<Customer>();
	list.add(cus1);
	list.add(cus2);
	
	
	
	
	
	try {
		JAXBContext context = JAXBContext.newInstance(Wrapper.class, Customer.class);
		Marshaller m = context.createMarshaller();
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		QName qname = new QName("customers");
		Wrapper<Customer> wrapper = new Wrapper<>(list);
		
		JAXBElement<Wrapper> element = 
				new JAXBElement<Wrapper>(qname, Wrapper.class, wrapper );
		
		m.marshal(element, out);
		
	} catch (JAXBException e) {
		e.printStackTrace();
	}
	
	
//	try {
//		JAXBContext context = JAXBContext.newInstance(Customer.class);
//		Marshaller m = context.createMarshaller();
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		m.marshal(cus, out);
//	} catch (JAXBException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	
	
	
	
	}

}
