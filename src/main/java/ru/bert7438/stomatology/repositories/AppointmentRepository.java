package ru.bert7438.stomatology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bert7438.stomatology.entities.Appointment;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findByCustomer(String customer);

    @Override
    <S extends Appointment> S saveAndFlush(S s);

}
