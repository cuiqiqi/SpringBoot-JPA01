package cn.com.taiji;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;




public class JpaTest {
	
	@PersistenceContext
    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;
    private static EntityTransaction transaction = null;

	@Before
	public void strat() {
		// 1. 创建EntityManagerFactory
		 factory = Persistence.createEntityManagerFactory("Spring-boot-jpa01");

		// 2. 创建EntityManager
		 entityManager = factory.createEntityManager();

		// 3.开启事务
		 transaction = entityManager.getTransaction();
		transaction.begin();
	}
	
	@After
	public void stop() {
		// 5. 提交事务.
		transaction.commit();

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}
	
	
	
	@Test
	public void OneToOneTest() {
	//Student类和StudId为一对一关系
		//StudId表添加数据
//		StudId studId = new StudId();
//		studId.setStudId(123456);
		
		//student表添加数据
//		Student student = new Student();
//		student.setName("王小明");
//		student.setStudId(studId);
//		entityManager.persist(studId);
//		entityManager.persist(student);
		
	
		//查询
//		Student singleResult = entityManager.createQuery("select s from Student s where s.id= :id and s.name= :name",Student.class)
//		.setParameter("id", 1)
//		.setParameter("name", "王小红")
//		.getSingleResult();
//	System.out.println(singleResult.toString);
		
		//更新								
//	int executeUpdate = entityManager.createQuery("update Student s set  s.name=?1 where s.id=?2")
//			.setParameter(1, "王刚")
//			.setParameter(2, 1)
//			.executeUpdate();
//		System.out.println(executeUpdate);
	
		//删除
		int executeUpdate1 = entityManager.createQuery("delete from Student s where s.id=?")
				.setParameter(1, 1)
				.executeUpdate();
			System.out.println(executeUpdate1);
	
	}
	
	@Test
	public void OneToManyTest() {
		//Boss类和Employee类为一对多关系
		//在数据库表中插入数据
		Boss bo = new Boss();
		bo.setName("张明");
		Employee emp = new Employee();
		emp.setName("张小明");
		Employee emp1 = new Employee();
		emp1.setName("王红");
		//关联
		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(emp);
		emplist.add(emp1);
		emp.setBoss(bo);
		emp1.setBoss(bo);
		entityManager.persist(bo);
		entityManager.persist(emp);
		entityManager.persist(emp1);
		
		
	}
	
	@Test
	public void ManyToManyTest() {
		//Persion类和Bank类的多对多关系
		Bank bank = new Bank();
		bank.setName("中国农业银行");
		Bank bank1 = new Bank();
		bank1.setName("中国建设银行");
		entityManager.persist(bank);
		entityManager.persist(bank1);
		
		List<Bank> bankList = new ArrayList<Bank>();
		bankList.add(bank);
		bankList.add(bank1);
		
		Persion per = new Persion();
		per.setName("王五");
		per.setBankList(bankList);
		entityManager.persist(per);

	}
	
	
}
