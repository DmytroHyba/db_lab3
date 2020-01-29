package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equipment_of_the_rescue_service")

public class EmergencySituation implements Serializable {
    @Column(name = "id_emergency_situation")
    @Id
    private Integer id_emergency_situation;
    @Column(name = "type_of_emergency")
    private String type_of_emergency;
    @Column(name = "date_of_emergency")
    private String date_of_emergency;
    @Column(name = "a_brief_description_of_the_call")
    private String a_brief_description_of_the_call;
    @Column(name = "extended_call_description")
    private String extended_call_description;
    @Column(name = "reason")
    private String reason;

    public EmergencySituation() {
    }

    public EmergencySituation(Integer id_emergency_situation, String type_of_emergency, String date_of_emergency, String a_brief_description_of_the_call, String extended_call_description, String reason) {
        this.id_emergency_situation = id_emergency_situation;
        this.type_of_emergency = type_of_emergency;
        this.date_of_emergency = date_of_emergency;
        this.a_brief_description_of_the_call = a_brief_description_of_the_call;
        this.extended_call_description = extended_call_description;
        this.reason = reason;
    }

    public Integer getId_emergency_situation() {
        return id_emergency_situation;
    }

    public void setId_emergency_situation(Integer id_emergency_situation) {
        this.id_emergency_situation = id_emergency_situation;
    }

    public String getType_of_emergency() {
        return type_of_emergency;
    }

    public void setType_of_emergency(String type_of_emergency) {
        this.type_of_emergency = type_of_emergency;
    }

    public String getDate_of_emergency() {
        return date_of_emergency;
    }

    public void setDate_of_emergency(String date_of_emergency) {
        this.date_of_emergency = date_of_emergency;
    }

    public String getA_brief_description_of_the_call() {
        return a_brief_description_of_the_call;
    }

    public void setA_brief_description_of_the_call(String a_brief_description_of_the_call) {
        this.a_brief_description_of_the_call = a_brief_description_of_the_call;
    }

    public String getExtended_call_description() {
        return extended_call_description;
    }

    public void setExtended_call_description(String extended_call_description) {
        this.extended_call_description = extended_call_description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "EmergencySituation{" +
                "id_emergency_situation=" + id_emergency_situation +
                ", type_of_emergency='" + type_of_emergency + '\'' +
                ", date_of_emergency='" + date_of_emergency + '\'' +
                ", a_brief_description_of_the_call='" + a_brief_description_of_the_call + '\'' +
                ", extended_call_description='" + extended_call_description + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
