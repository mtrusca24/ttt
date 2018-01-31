package camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Eu {

	public static void main(String[] args) throws Exception {
		
		CamelContext contex=new DefaultCamelContext();	
		
		contex.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
			
				from("file:data/inbox")
				.process(new Processor() {
					
					@Override
					public void process(Exchange arg0) throws Exception {
						
						System.out.println(arg0.getExchangeId());
						System.out.println(arg0.getFromRouteId());
						System.out.println(arg0.getIn().getHeader("CamelFileName"));
					}
				})
				.to("file:data/outbox1");
				
			}
			
			
			
			
		});
		
		contex.start();
		
		Thread.sleep(2000);
		
		contex.stop();
		

	}

}
