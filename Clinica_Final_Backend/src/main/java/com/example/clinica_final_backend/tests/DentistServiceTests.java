package com.example.clinica_final_backend.tests;

import com.example.clinica_final_backend.dao.DentistDaoH2;
import com.example.clinica_final_backend.model.Dentist;
import com.example.clinica_final_backend.service.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class DentistServiceTests {

    private static DentistService dentistService = new DentistService(new DentistDaoH2());

    @Test
    public void test_registerOdontologist() {
        Dentist dentist_1 = new Dentist(001, "Adam", "Mikhailov");
        Dentist dentist_2 = new Dentist(002, "Shinzo", "Abe");

        Dentist dentResult_1 = dentistService.register(dentist_1);
        Dentist dentResult_2 = dentistService.register(dentist_2);

        assertEquals(dentist_1, dentResult_1);
        assertEquals(dentist_2, dentResult_2);

    }

    @Test
    public void test_findById(){
        Dentist dentist_3 = new Dentist(3, "Anna", "Ignatiev");
        Dentist dentist_4 = new Dentist(4, "Cristian", "Dumitru");
        Dentist dentist_5 = new Dentist(5, "Andrea", "Negrescu");

        Dentist resultsFound_5;
        resultsFound_5 = dentistService.getOdontologistIDao().findById(5);

        Dentist resultsFound_3;
        resultsFound_3 = dentistService.getOdontologistIDao().findById(3);

        Dentist resultsFound_4;
        resultsFound_4 = dentistService.getOdontologistIDao().findById(4);


    }

   @Test
    public void test_showAll(){
        List<Dentist> dentists = dentistService.showAll();
        Assertions.assertNotNull(dentists);

    }
}
