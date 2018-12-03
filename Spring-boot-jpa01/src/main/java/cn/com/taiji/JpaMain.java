package cn.com.taiji;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 *
 */
public class JpaMain {
    public static void main( String[] args ){
    	
    	// 1. 创建EntityManagerFactory
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Spring-boot-jpa");

    	// 2. 创建EntityManager
    	EntityManager entityManager = factory.createEntityManager();

    	// 3.开启事务
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	// 4. 持久化操作
    	
    	
    	
    	
    	
    	
    	// 5. 提交事务
    			transaction.commit();

    			// 6. 关闭EntityManager
    			entityManager.close();

    			// 7. 关闭EntityManagerFactory
    			factory.close();
    	
        
    }
}
