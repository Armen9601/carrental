package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clients {
    private int id;
    private String name;
    private String surName;
    private String email;
    private int age;
    private String driverLicenseNumber;
    private int getQuality;
    private int carID;
}
