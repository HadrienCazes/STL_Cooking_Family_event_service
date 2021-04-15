package com.event.event_planification.Event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Event {

    @Id
    @SequenceGenerator(
            name= "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "event_sequence")
    private Integer id;

    private String title,address,description;
    private Integer host; // Should be a User instead of a String name

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yy")
    private LocalDate event_date;

//    @ElementCollection
//    private List<Integer> participants; // Should be switched to User in the future ... For now, we will use names
    private String participants; // participants_id will be stored as a String with concat;

    public Event(String title, Integer host, String address, String desc, String participants, LocalDate event_date) {
        this.title = title;
        this.host = host;
        this.address = address;
        this.description = desc;
        this.participants = participants;
        this.event_date = event_date;
    }
}
