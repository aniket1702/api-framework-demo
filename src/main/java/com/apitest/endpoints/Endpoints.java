package com.apitest.endpoints;


import com.apitest.config.ConfigFactory;
import lombok.Data;

@Data
public final class Endpoints {
    private Endpoints()
    {

    }

    
    public static final String BASE_URI = ConfigFactory.getConfig().baseURI();
    public static final String CREATE_STUDENTS = BASE_URI+"/student";
    public static final String READ_STUDENTS_DETAILS = BASE_URI+"/student/";
    public static final String UPDATE_STUDENTS_DETAILS = BASE_URI+"/student/{id}";
    public static final String DELETE_STUDENT_DETAILS = BASE_URI+"/student/{id}";

}
