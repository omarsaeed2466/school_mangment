package com.example.school_mangment.Repository;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
