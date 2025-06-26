package com.lambokProject;

import lombok.*;

@NoArgsConstructor
//@AllArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeLambok {
    @ToString.Exclude public Integer empId;
    @EqualsAndHashCode.Exclude public String name;
    @EqualsAndHashCode.Exclude public Integer salary;
}
