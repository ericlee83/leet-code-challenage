package com.pattern.creational.builder;

import com.pattern.creational.builder.bulderonmethod.ClientBuilder;
import com.pattern.creational.builder.withinheritance.Child;
import com.pattern.creational.builder.withinheritance.Parent;
import com.pattern.creational.builder.withinheritance.Student;
import com.pattern.creational.builder.bulderonmethod.ImmutableClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void TestBuilder(){
        BankAccount account = new BankAccount
                .BankAccountBuilder("","")
                .wantNewsletter(false)
                .withEmail("abc@cba.com")
                .build();
        assertNotNull(account);
    }

    @Test
    void TestInheritance(){
        Parent parent = Parent.builder()
                .parentName("Eric")
                .parentAge(36)
                .build();
        assertEquals(36, parent.getParentAge());

        Child child = Child.builder()
                .parentName("Eric")
                .parentAge(36)
                .childName("Thea")
                .childAge(0)
                .build();
        assertEquals("Eric",child.getParentName());

        Student student = Student.builder()
                .parentName("Eric")
                .parentAge(36)
                .childName("Thea")
                .childAge(0)
                .schoolName("Sydney")
                .build();
        assertEquals("Sydney",student.getSchoolName());

        ImmutableClient client = ClientBuilder.builder()
                .id(0).name("Eric").build();
        assertEquals("Eric",client.getName());
    }

}