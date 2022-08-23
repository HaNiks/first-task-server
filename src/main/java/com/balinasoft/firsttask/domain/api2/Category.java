package com.balinasoft.firsttask.domain.api2;

import com.balinasoft.firsttask.domain.Image;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude
    private Date date;

    @OneToMany
    @JsonInclude
    private List<Image> images;
}
