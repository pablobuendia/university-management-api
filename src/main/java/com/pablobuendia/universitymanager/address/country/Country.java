package com.pablobuendia.universitymanager.address.country;

import com.pablobuendia.universitymanager.commons.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
}
