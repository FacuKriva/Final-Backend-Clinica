package com.example.clinica_final_backend.tests;

import com.example.clinica_final_backend.dao.OdontologistDaoH2;
import com.example.clinica_final_backend.model.Odontologist;
import com.example.clinica_final_backend.service.OdontologistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class OdontologistServiceTests {

    private static OdontologistService odontologistService = new OdontologistService(new OdontologistDaoH2());

    @Test
    public void test_registerOdontologist() {
        Odontologist odontologist_1 = new Odontologist(001, "Adam", "Mikhailov");
        Odontologist odontologist_2 = new Odontologist(002, "Shinzo", "Abe");

        Odontologist odontResult_1 = odontologistService.register(odontologist_1);
        Odontologist odontResult_2 = odontologistService.register(odontologist_2);

        assertEquals(odontologist_1, odontResult_1);
        assertEquals(odontologist_2, odontResult_2);

    }

    @Test
    public void test_findById(){
        Odontologist odontologist_3 = new Odontologist(3, "Anna", "Ignatiev");
        Odontologist odontologist_4 = new Odontologist(4, "Cristian", "Dumitru");
        Odontologist odontologist_5 = new Odontologist(5, "Andrea", "Negrescu");

        Odontologist resultsFound_5;
        resultsFound_5 = odontologistService.getOdontologistIDao().findById(5);

        Odontologist resultsFound_3;
        resultsFound_3 = odontologistService.getOdontologistIDao().findById(3);

        Odontologist resultsFound_4;
        resultsFound_4 = odontologistService.getOdontologistIDao().findById(4);


    }

   @Test
    public void test_showAll(){
        List<Odontologist> odontologists = odontologistService.showAll();
        Assertions.assertNotNull(odontologists);

    }
}
