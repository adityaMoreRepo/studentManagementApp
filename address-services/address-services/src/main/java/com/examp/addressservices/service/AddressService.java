package com.examp.addressservices.service;

import com.examp.addressservices.entity.Address;
import com.examp.addressservices.exception.AddressNotFoundException;
import com.examp.addressservices.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressService {
    @Autowired
    AddressRepository repository;
    public Address getAddressById(int id) {
        log.info("Inside getAddressById of AddressService");
        return repository.findById(id)
                .orElse(null);
    }

    public List<Address> getAddresses() {
        log.info("Inside getAddresses of AddressService");
        return repository.findAll();
    }

    public Address updateAddress(int id, Address address1) {
        log.info("Inside updateAddress method of AddressService");
        Address address = new Address();
        try{
            address = repository.findById(id).orElseThrow(() -> new AddressNotFoundException("address_id "+ id +" is invalid"));
        }
        catch (AddressNotFoundException e){
            e.printStackTrace();
        }
        address.setFlat_no(address1.getFlat_no());
        address.setCity(address1.getCity());
        address.setMobile_no(address1.getMobile_no());
        address.setPin(address1.getPin());
        address.setRoad(address1.getRoad());
        address.setState(address1.getState());

        return repository.save(address);

    }

    public ResponseEntity removeAddress(int id) {
        log.info("Inside removeAddress method of AddressService");
        Address address = new Address();
        try{
            address = repository.findById(id).orElseThrow(() -> new AddressNotFoundException("address_id "+ id +" is invalid"));
        }
        catch (AddressNotFoundException e){
            e.printStackTrace();
        }
        repository.delete(address);
        return ResponseEntity.ok().build();
    }

    public Address addAddress(Address address) {
        log.info("Inside addAddress of AddressService");
        return repository.save(address);
    }
}
