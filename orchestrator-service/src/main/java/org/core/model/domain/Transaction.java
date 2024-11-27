package org.core.model.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(unique = true, columnDefinition = "UUID")
    private UUID id;

    @Column
    private String message;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @ManyToOne
    @Nullable
    private Category category;

    @Column
    private Double amount;

    @Column(name="telegram_user_id")
    @Nullable
    private Long telegramUserId;

    @OneToOne(mappedBy = "transaction",
            fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Suggestion suggestion;
}
