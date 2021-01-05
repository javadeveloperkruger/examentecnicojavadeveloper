package com.examen.tecnico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ec.com.kruger.examen.Sucursal;



public class BuscarSucursalProcessor implements Processor {
	
		@Override
	public void process(Exchange exchange) throws Exception {
			 // get the id of the input
	        Integer id = exchange.getIn().getBody(BuscarSucursalInput.class).getIdBanco();
System.out.println("IdBanco"+id);
	        
	        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProjects" );
		      EntityManager entitymanager = emfactory.createEntityManager();
		      
		      Query query = entitymanager.createNamedQuery("find Sucursal by idBanco");
		      query.setParameter("id", id);
		      
		      //query.setParameter("id", 1204);
		      
		      List results = query.getResultList();
				
				List<Sucursal> resultList = query.getResultList();
				System.out.println("num of Sucursal:" + resultList.size());
				for (Sucursal next : resultList) {
					System.out.println("next sucursal: " + next.getIdbanco());
					System.out.println("next sucursal: " + next);
					BuscarSucursalOutput output = new BuscarSucursalOutput();
				       output.setNombre(next.getNombre());
				       output.setDireccion(next.getDireccion());
				       output.setDireccion(next.getFecharegistro());
				        exchange.getOut().setBody(output);
				}
		   }
		
	        // set reply including the id
	       // BuscarSucursalOutput output = new BuscarSucursalOutput();
	       // output.setNombre("Sucursal_1");
	        //output.setCiudad("Quito");
	       // output.setDireccion("El Batan");
	       // exchange.getOut().setBody(output);
		
	
}
