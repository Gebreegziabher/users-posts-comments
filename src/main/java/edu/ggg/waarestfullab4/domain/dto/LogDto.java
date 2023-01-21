package edu.ggg.waarestfullab4.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class LogDto {
    private int id;
    LocalDate Date;
    LocalTime Time;
    private String Principle;
    private String Operation;
}
