package com.balinasoft.firsttask.domain.api2;

import com.balinasoft.firsttask.domain.Image;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 1000)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany
    private List<Image> images;
}
