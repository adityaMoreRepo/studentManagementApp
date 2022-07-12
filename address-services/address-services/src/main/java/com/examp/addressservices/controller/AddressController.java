package com.examp.addressservices.controller;

import com.examp.addressservices.entity.Address;
import com.examp.addressservices.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AddressController {
    @Autowired
    AddressService service;
    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable int id){
        log.info("Inside getAddressById of AddressController");
        return service.getAddressById(id);
    }

    @GetMapping("/addresses")
    public List<Address> getAddresses(){
        log.info("Inside getAddresses of AddressController");
        return service.getAddresses();
    }
    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody Address address){
        log.info("Inside updateAddress method of AddressController");
        return service.updateAddress(id, address);
    }

    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody Address address){
        log.info("Inside addAddress method of AddressController");
        return service.addAddress(address);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity removeAddress(@PathVariable int id){
        log.info("Inside removeAddress method of AddressController");
        return service.removeAddress(id);
    }
}
