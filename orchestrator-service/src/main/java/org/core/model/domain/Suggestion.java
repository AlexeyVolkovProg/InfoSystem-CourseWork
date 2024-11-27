package org.core.model.domain;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="suggestions")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Suggestion {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(unique = true, columnDefinition = "UUID")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name="suggested_category_id")
    private Long suggestionCategoryId;

    @Column
    private Float accuracy;

    @Column
    private Boolean isCorrect; // todo колонка пока под вопросом

    @Column
    private String algorithm;
}
