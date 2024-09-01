package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ReflectionUtilsTest {
    @MockBean
    ApplicationDao applicationDao;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    CollegeStudent student;
    @Autowired
    StudentGrades studentGrades;
    //    reflectionUtils to access private files/methods
    //    either to set or get them to test.

    @BeforeEach
    void setup(){
        student.setFirstname("Eric");
        student.setLastname("Eric");
        student.setEmailAddress("Eric@gmail.com");
        student.setStudentGrades(studentGrades);
        ReflectionTestUtils.setField(student,"id",1);
    }
    @DisplayName("Reflection utils for ID")
    @Test
    void test_ReflectionUtils(){
        assertEquals(1,ReflectionTestUtils.getField(student,"id"));
    }

    @DisplayName("Check full name and ID")
    @Test
    void test_getFullNameAndId(){
        assertEquals("1 Eric Eric",ReflectionTestUtils.invokeMethod(
                student,"getNameAndId"
        ));
    }

}
