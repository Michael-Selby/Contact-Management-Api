package com.sterry.contact.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
private String name;
private String number;

}
