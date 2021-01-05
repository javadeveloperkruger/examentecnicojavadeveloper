package ec.kruger.com.examen;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ec.com.kruger.examen.Sucursal;

public class SucursalProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Integer id = exchange.getIn().getBody(SucursalInput.class).getIdBanco();
		System.out.println("IdBanco" + id);

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAProjects");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find Sucursal by idBanco");
		query.setParameter("id", id);
		List results = query.getResultList();

		List<Sucursal> resultList = query.getResultList();
		System.out.println("num of Sucursal:" + resultList.size());
		for (Sucursal next : resultList) {
			System.out.println("next sucursal: " + next.getIdbanco());
			System.out.println("next sucursal: " + next);
			SucursalOutput output = new SucursalOutput();
			output.setNombre(next.getNombre());
			output.setDireccion(next.getDireccion());
			output.setFechaRegistro(next.getFecharegistro());
			exchange.getOut().setBody(output);
		}
	}

}
