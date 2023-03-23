package com.codekul.Spring6DecBatch;

import com.codekul.Spring6DecBatch.config.AppConfig;
import com.codekul.Spring6DecBatch.di.Teacher;
import com.codekul.Spring6DecBatch.ioc.Airtel;
import com.codekul.Spring6DecBatch.ioc.BubbleSort;
import com.codekul.Spring6DecBatch.ioc.InsertionSort;
import com.codekul.Spring6DecBatch.ioc.Vodaphone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Spring6DecBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6DecBatchApplication.class, args);

		ApplicationContext context
				=
				new AnnotationConfigApplicationContext(AppConfig.class);   //ioc

		Teacher teacher = context.getBean("teacher", Teacher.class);
		teacher.show();


		BubbleSort bubbleSort = context.getBean("bubbleSort",BubbleSort.class);
		bubbleSort.sort();


		InsertionSort insertionSort = context.getBean("insertionSort", InsertionSort.class);
		insertionSort.sort();


		Vodaphone vodaphone = context.getBean("vodaphone",Vodaphone.class);
        vodaphone.show();


		Airtel airtel=context.getBean("airtel",Airtel.class);
        airtel.show();
}
}