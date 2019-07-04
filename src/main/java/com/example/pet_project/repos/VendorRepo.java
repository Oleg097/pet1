package com.example.pet_project.repos;

import com.example.pet_project.domain.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorRepo extends CrudRepository<Vendor, Integer> {
}
