package org.core.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.core.model.enums.Type;

@Entity
@Table(name = "categories",
uniqueConstraints = {
        @UniqueConstraint(name="UniqueAccIdAndCategoryName", columnNames = {"name", "account_id"})
})
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Embedded
    private Type type;
}
