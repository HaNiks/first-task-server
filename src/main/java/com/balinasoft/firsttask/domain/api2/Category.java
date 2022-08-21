package com.balinasoft.firsttask.domain.api2;

import com.balinasoft.firsttask.domain.Image;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime localDateTime;


    @OneToMany
    private List<Image> images;
}
