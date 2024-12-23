package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
