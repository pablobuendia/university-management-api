package com.pablobuendia.universitymanager.student;

import com.pablobuendia.universitymanager.commons.BaseEntity;
import com.pablobuendia.universitymanager.address.Address;
import com.pablobuendia.universitymanager.university.University;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "universityId")
    private University university;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Address> addressList;
}
