package ru.bert7438.stomatology.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "customer")
    private String customer;
    @Column(name = "doctor_id")
    private int doctor_id;
    @Column(name = "notes")
    private String notes;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "phoneNumber")
    private String phoneNumber;

}
