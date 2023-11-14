package com.example.school_mangment.service;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.ClassRoom;
import com.example.school_mangment.Repository.AddressRepository;
import com.example.school_mangment.Repository.ClassRomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository= addressRepository;
    }
    public List<Address> getAllAddress(){
        return this.addressRepository.findAll();
    }
    public Address AddNewAddress(Address address){
        return this.addressRepository.save(address);
    }
    public Address findById(Integer id) {
        if(id==0)
            throw new IllegalStateException("this id Caddress not found");

        Optional<Address> add = addressRepository.findById(id);
        if(add !=null&&add .get()!=null){
            return add .get();
        }
        return null;
    }
    public void deleteAddressById(Integer AddressId) {
        boolean exists = addressRepository.existsById(AddressId);
        if (!exists) {
            throw new IllegalStateException("Address with id " + AddressId + "does not exist");
        }
        this.addressRepository .deleteById(AddressId);
    }
    public Address updateAddress(Address address){
        return this.addressRepository.save(address);
    }
}
