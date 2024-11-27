package org.core.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyMindAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id", unique = true)
    private Long chatId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Transaction> transactions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @JsonManagedReference
    private Set<User> users;
}
