package com.balinasoft.firsttask.dto.api2;

import com.balinasoft.firsttask.domain.Image;
import com.balinasoft.firsttask.system.json.UnixTimestampSereliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTOOut {

    @ApiModelProperty(required = true)
    int id;

    @ApiModelProperty(required = true)
    String name;

    @ApiModelProperty(required = true, dataType = "java.lang.Long", example = "1262307723")
    @JsonSerialize(using = UnixTimestampSereliazer.class)
    LocalDateTime localDateTime;

    @ApiModelProperty(required = true)
    List<Image> images;
}
