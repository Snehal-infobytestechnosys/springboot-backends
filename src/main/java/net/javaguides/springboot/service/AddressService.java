package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Address;
import net.javaguides.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

    }
}
