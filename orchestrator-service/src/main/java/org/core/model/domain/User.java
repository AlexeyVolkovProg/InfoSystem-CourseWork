package org.core.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String lastname;

    @Column
    private String photoUrl;

    @Column
    private String authDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private MoneyMindAccount account;
}
