package com.zhanibek.tasktracker.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String startDate;

    private String endDate;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Task> tasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return id != null && Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
