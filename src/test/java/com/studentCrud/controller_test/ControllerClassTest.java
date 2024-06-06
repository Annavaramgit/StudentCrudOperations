//package com.studentCrud.controller_test;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.studentCrud.controller.ControllerClass;
//import  com.studentCrud.entity.Student;
//import com.studentCrud.service.StudentService;
//
//@WebMvcTest(value=ControllerClass.class)
//public class ControllerClassTest {
//
//	@MockBean
//	private StudentService studentService;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private ControllerClass controllerClass;
//	
//	@Test
//	public void testGetAll() throws Exception {
//		
//		List<Student> listStudents = Arrays.asList(
//	            new Student(1, 500, "john.doe","Aditya")
//	           
//	        );
//		
//		when(studentService.fetchingAll()).thenReturn(listStudents);
//		
//		MockHttpServletRequestBuilder request=	MockMvcRequestBuilders.get("/getAll");
//		ResultActions perform = mockMvc.perform(request);
//		MvcResult res =	perform.andReturn();
//		MockHttpServletResponse respons =    res.getResponse();
//		int statusCode=respons.getStatus();		
//		Assertions.assertEquals(200,statusCode);
//		
//		
//	}
//	
//	
//	
//}
