package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockitoAnnotationTest {
    @Autowired
    ApplicationContext context;
    @Autowired
    CollegeStudent StudentOne;
    @Autowired
    StudentGrades studentGrades;

    @MockBean // mockBean can be used to directly injectBeans using Autowired
    ApplicationDao applicationDao;
    @Autowired
    ApplicationService applicationService;

    @DisplayName("When and Then")
    @Test
    void test_When_And_Then(){
//        1. setting up expectation
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()))
                .thenReturn(100.00d);
//        in above step we have set an expectation that if addGradeResultsForSingleClass is called
//        then the method should return 100 as result
//        2. Execution
        assertEquals(100.00,applicationService.
                addGradeResultsForSingleClass(studentGrades.getMathGradeResults()));
    }

}
