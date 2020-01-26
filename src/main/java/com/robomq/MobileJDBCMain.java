package com.robomq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.robomq.config.AppConfig;
import com.robomq.dao.MobileDao;
import com.robomq.pojo.Mobile;

public class MobileJDBCMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
		MobileDao mobileDAO = context.getBean(MobileDao.class);
	
		System.out.println("List of mobiles is:");
	
		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}
	
		System.out.println("\nGet mobile with ID 1");
	
		Mobile mobileById = mobileDAO.getMobileById(1);
		System.out.println(mobileById);
	
		System.out.println("\nCreating Mobile List: ");
		Mobile mobile = new Mobile(3,70,20000,"Oppo","Android");
		System.out.println(mobile);
		mobileDAO.createMobile(mobile);
		System.out.println("\nList of mobile is:");
	
		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}
	
		System.out.println("\nDeleting Mobile with ID 2");
		mobileDAO.deleteMobile(mobileById);
	
		System.out.println("\nUpdate Mobile with ID 3");
	
		Mobile m = mobileDAO.getMobileById(3);
		m.setName("CHANGED");
		mobileDAO.updateMobile(m);
	
		System.out.println("\nList of mobile is:");
		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}
	
		context.close();
	
	}
}