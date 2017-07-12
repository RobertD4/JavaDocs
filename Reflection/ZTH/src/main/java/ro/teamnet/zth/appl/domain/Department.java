package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Robert.Dumitrescu on 7/12/2017.
 */
@Table(name="departments")
public class Department {
    @Id(name = "department_id")
    private Long id;
    @Column(name = "department_departmentName")
    private String departmentName;
    @Column(name = "department_location")
    private Location location;

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
