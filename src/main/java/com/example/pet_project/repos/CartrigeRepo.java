package com.example.pet_project.repos;

import com.example.pet_project.domain.Cartrige;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartrigeRepo extends CrudRepository<Cartrige, Integer> {

    List<Cartrige> findByVendorContains(String vendor);



}
