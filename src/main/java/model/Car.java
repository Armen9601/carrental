package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private double matorVolume;
    private String picUrl;
    private double price;
    private boolean rented=false;
}
