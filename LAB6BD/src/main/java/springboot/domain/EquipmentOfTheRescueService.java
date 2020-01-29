package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equipment_of_the_rescue_service")

public class EquipmentOfTheRescueService implements Serializable{
    @Column(name = "id_equipment_of_the_rescue_service")
    @Id
    private Integer id_equipment_of_the_rescue_service;
    @Column(name = "type_of_lifeguard")
    private String type_of_lifeguard;
    @Column(name = "type_of_rescue_car")
    private String type_of_rescue_car;
    @Column(name = "departure_time_of_the_rescue_car")
    private int departure_time_of_the_rescue_car;
    @Column(name = "arrival_time_of_the_rescue_car")
    private int arrival_time_of_the_rescue_car;

    public EquipmentOfTheRescueService() {
    }

    public EquipmentOfTheRescueService(Integer id_equipment_of_the_rescue_service, String type_of_lifeguard, String type_of_rescue_car, int departure_time_of_the_rescue_car, int arrival_time_of_the_rescue_car) {
        this.id_equipment_of_the_rescue_service = id_equipment_of_the_rescue_service;
        this.type_of_lifeguard = type_of_lifeguard;
        this.type_of_rescue_car = type_of_rescue_car;
        this.departure_time_of_the_rescue_car = departure_time_of_the_rescue_car;
        this.arrival_time_of_the_rescue_car = arrival_time_of_the_rescue_car;
    }

    public Integer getId_equipment_of_the_rescue_service() {
        return id_equipment_of_the_rescue_service;
    }

    public void setId_equipment_of_the_rescue_service(Integer id_equipment_of_the_rescue_service) {
        this.id_equipment_of_the_rescue_service = id_equipment_of_the_rescue_service;
    }

    public String getType_of_lifeguard() {
        return type_of_lifeguard;
    }

    public void setType_of_lifeguard(String type_of_lifeguard) {
        this.type_of_lifeguard = type_of_lifeguard;
    }

    public String getType_of_rescue_car() {
        return type_of_rescue_car;
    }

    public void setType_of_rescue_car(String type_of_rescue_car) {
        this.type_of_rescue_car = type_of_rescue_car;
    }

    public int getDeparture_time_of_the_rescue_car() {
        return departure_time_of_the_rescue_car;
    }

    public void setDeparture_time_of_the_rescue_car(int departure_time_of_the_rescue_car) {
        this.departure_time_of_the_rescue_car = departure_time_of_the_rescue_car;
    }

    public int getArrival_time_of_the_rescue_car() {
        return arrival_time_of_the_rescue_car;
    }

    public void setArrival_time_of_the_rescue_car(int arrival_time_of_the_rescue_car) {
        this.arrival_time_of_the_rescue_car = arrival_time_of_the_rescue_car;
    }

    @Override
    public String toString() {
        return "EquipmentOfTheRescueService{" +
                "id_equipment_of_the_rescue_service=" + id_equipment_of_the_rescue_service +
                ", type_of_lifeguard='" + type_of_lifeguard + '\'' +
                ", type_of_rescue_car='" + type_of_rescue_car + '\'' +
                ", departure_time_of_the_rescue_car=" + departure_time_of_the_rescue_car +
                ", arrival_time_of_the_rescue_car=" + arrival_time_of_the_rescue_car +
                '}';
    }
}

