package com.HPE.HPEFinal;

import com.HPE.HPEFinal.controller.EmployeeController;
import com.HPE.HPEFinal.model.Employee;
import com.HPE.HPEFinal.servicerepo.EmployeeManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)

public class EmployeeControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objm = new ObjectMapper();// we can't convert a pojo object directly into json without springboot help
    ObjectWriter objw = objm.writer();// but we can use object mapper and writer

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    Employee employee1 = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
    Employee employee2 = new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager");
    Employee employee3 = new Employee("3", "Bob", "Johnson", "bob.johnson@example.com", "Designer");


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    //  get
    @Test
    public void getAllEmployees()throws Exception{
        List<Employee> emps = new ArrayList<>(Arrays.asList(employee1,employee2,employee3));
        Mockito.when(employeeManager.getEmployees()).thenReturn(emps);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mail", Matchers.is("john.doe@example.com")));

    }

    //post

    @Test
    public void addEmployee() throws Exception {
        Employee e = Employee.builder()
                .employee_id("4")
                .first_name("yoyo")
                .last_name("baba")
                .mail("new mail bro")
                .title("Tester")
                .build();

        Mockito.when(employeeManager.addEmployee(e)).thenReturn(e);
        String x = objw.writeValueAsString(e);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/employees/add")
                .contentType(MediaType.APPLICATION_JSON)//returning content type of book in json format
                .accept(MediaType.APPLICATION_JSON)// accepting request by json type
                .content(x);

        mockMvc.perform(mockRequest)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employee_id", notNullValue()));
    }

//    @Test
//    public void updateEmp()throws Exception{
//        Employee upEmp = Employee.builder()
//                .employee_id("2")
//                .first_name("hello")
//                .last_name("world")
//                .mail("babayaga@org.com")
//                .title("hi bro")
//                .build();
//        Mockito.when(employeeManager.findEmp(employee2.getEmployee_id(),employee2)).thenReturn(employee2);
//        Mockito.when(employeeManager.saveEmp(employee2,upEmp)).thenReturn(upEmp);
//
//        String xupdate = objw.writeValueAsString(upEmp);
//        MockHttpServletRequestBuilder mockreq = MockMvcRequestBuilders.put("/employees/update/id")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(xupdate);
//        mockMvc.perform(mockreq)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$",notNullValue()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.first_name",Matchers.is("hello")));
//    }
@Test
public void updateEmp() throws Exception {
    Employee upEmp = Employee.builder()
            .employee_id("2")
            .first_name("hello")
            .last_name("world")
            .mail("babayaga@org.com")
            .title("hi bro")
            .build();

    Mockito.when(employeeManager.findEmp(employee2.getEmployee_id(), upEmp)).thenReturn(employee2);
    Mockito.when(employeeManager.saveEmp(Mockito.eq(upEmp), Mockito.eq(employee2))).thenReturn(upEmp);

    String xupdate = objw.writeValueAsString(upEmp);
    MockHttpServletRequestBuilder mockreq = MockMvcRequestBuilders.put("/employees/update/2")  // Adjust the path variable value
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(xupdate);

    mockMvc.perform(mockreq)
            .andExpect(MockMvcResultMatchers.status().isOk())
           // .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))  // Ensure the response has a value at the root
            .andExpect(MockMvcResultMatchers.jsonPath("$.first_name", Matchers.is("hello")));
}


}
