package ec.com.kruger.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.com.kruger.examen.Banco;
import ec.com.kruger.examen.Sucursal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//EntityManager entityManager = JPAUtility.getEntityManager();	
		//Banco emp = entityManager.find(Banco.class, new Integer(1));
		//System.out.println("Name:"+ emp.getDireccion()+", City:"+ emp.getNombre());
		//JPAUtility.close();		
		//System.out.println("Done");
		
		
		
		
		
		//crearBanco();
		//consultarBanco();
		//ConsultarSucursal();
		ConsultarSucursalId();
    }
	
	
	public static void crearBanco() {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			
										
			emf = Persistence.createEntityManagerFactory("JPAProjects");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Banco banco = new Banco();
			banco.setIdbanco(2);
			banco.setNombre("dasda");
			banco.setDireccion("direccion");
			banco.setFecharegistro("hoy");
			
			entityManager.persist(banco);

			transaction.commit();
			
			Query q = entityManager.createQuery("select s from Banco s");

			List<Banco> resultList = q.getResultList();
			System.out.println("num of banco:" + resultList.size());
			for (Banco next : resultList) {
				System.out.println("next student: " + next);
			}


			
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}


	
public static void consultarBanco() {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			
										
			emf = Persistence.createEntityManagerFactory("JPAProjects");
			entityManager = emf.createEntityManager();

			Query query = entityManager.createQuery("select s from Banco s");
			
			List results = query.getResultList();
		
			List<Banco> resultList = query.getResultList();
			System.out.println("num of banco:" + resultList.size());
			for (Banco next : resultList) {
				System.out.println("next student: " + next);
			}


		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}



public static void consultarSucursal() {
	
	EntityManagerFactory emf = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	try {
		
									
		emf = Persistence.createEntityManagerFactory("JPAProjects");
		entityManager = emf.createEntityManager();

		Query query = entityManager.createQuery("select s from Sucursal s");
		
		List results = query.getResultList();
	
		List<Banco> resultList = query.getResultList();
		System.out.println("num of banco:" + resultList.size());
		for (Banco next : resultList) {
			System.out.println("next student: " + next);
		}


	} catch (Exception e) {
		System.out.println(e);
		transaction.rollback();
	} finally {
		entityManager.close();
		emf.close();
	}
}


public static void ConsultarAllBank(){
	{
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProjects" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      Query query = entitymanager.createNamedQuery("Banco.findAll");
	      //query.setParameter("id", 1204);
	      
	      List results = query.getResultList();
			
			List<Banco> resultList = query.getResultList();
			System.out.println("num of banco:" + resultList.size());
			for (Banco next : resultList) {
				System.out.println("next student: " + next);
			}
	   }
}



public static void ConsultarSucursal(){
	{
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProjects" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      Query query = entitymanager.createNamedQuery("Sucursal.findAll");
	      //query.setParameter("id", 1204);
	      
	      List results = query.getResultList();
			
			List<Sucursal> resultList = query.getResultList();
			System.out.println("num of Sucursal:" + resultList.size());
			for (Sucursal next : resultList) {
				System.out.println("next sucursal: " + next.getIdbanco());
				System.out.println("next sucursal: " + next);
			}
	   }
}

public static void ConsultarSucursalId(){
	{
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPAProjects" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      Query query = entitymanager.createNamedQuery("find Sucursal by idBanco");
	      query.setParameter("id", 1);
	      
	      //query.setParameter("id", 1204);
	      
	      List results = query.getResultList();
			
			List<Sucursal> resultList = query.getResultList();
			System.out.println("num of Sucursal:" + resultList.size());
			for (Sucursal next : resultList) {
				System.out.println("next sucursal: " + next.getIdbanco());
				System.out.println("next sucursal: " + next);
			}
	   }
}

	}


