package com.aulamatriz.ms.management.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Auto incrementable
    private long id;
    @Column(length = 20)
    private String name;
    @Column(length = 30)
    private String email;
    @Column(length = 12)
    private String document;
    @Column(name = "type_document")
    private String typeDocument;
}
