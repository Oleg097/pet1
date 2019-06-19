package com.example.pet_project.repos;

import com.example.pet_project.domain.Printer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrinterRepo extends CrudRepository<Printer, Integer> {

    List<Printer>findByVendorContains(String vendor);


}
