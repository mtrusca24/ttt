package camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Xpath {

	public static void main(String[] args) throws Exception {
		
CamelContext contex=new DefaultCamelContext();	
		
		contex.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				
				
				from("file:src/data?noop=true&fileName=2.xml")
				
				.setHeader("ala", xpath("bookstore/book/title"))
				.process(new Processor() {
					
					@Override
					public void process(Exchange arg0) throws Exception {
						
						String cuvant=arg0.getIn().getHeader("ala",String.class);
						
						System.out.println(cuvant);
						System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					}
				});
				
				
				
			}
		});
		
		
		contex.start();
		
		Thread.sleep(3000);
		contex.stop();

	}

}
