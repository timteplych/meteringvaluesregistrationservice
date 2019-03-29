package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ttv.meteringvaluesregistrationservice.model.ConsumerAccount;

/**
 * @author Teplykh Timofey  28.03.2019
 */
@Repository
public interface ConsumerAccountRepository extends JpaRepository<ConsumerAccount,Long> {

    ConsumerAccount getByAccountNumber(String accountNumber);

}
