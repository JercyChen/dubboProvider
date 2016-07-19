package com.cn.main;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "spring/applicationProvider.xml","spring/applicationContext-context.xml" });
			context.start();
			System.out.println("Press any key to exit.");
			System.in.read();
		} catch (BeansException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}