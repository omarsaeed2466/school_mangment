package com.example.school_mangment.Controller;

import com.example.school_mangment.Entity.Address;
import com.example.school_mangment.Entity.Course;
import com.example.school_mangment.service.AddressService;
import com.example.school_mangment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Address")
public class AddressController {
    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/getAllAddress")
    public List<Address> getAllAddress(){
        return this.addressService.getAllAddress();
    }

    @PostMapping("/AddNewAddress")
    public  Address AddNewAddress(@RequestBody Address address){
        return this.addressService.AddNewAddress(address);

    }
    @GetMapping("/{id}")
    public Address findById(@PathVariable Integer id){
        return this.addressService.findById(id);
    }


    @DeleteMapping(path = "{AddressId}")
    public void deleteAddress(@PathVariable("AddressId") Integer AddressId){
        this.addressService.deleteAddressById(AddressId);
    }
    @PostMapping("/updateAddress")
    public Address updateAddress(@RequestBody Address address){
        return this.addressService.updateAddress(address);
    }
}
