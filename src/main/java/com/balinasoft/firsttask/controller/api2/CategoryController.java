package com.balinasoft.firsttask.controller.api2;

import com.balinasoft.firsttask.service.api2.CategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/category")
@Api(tags = "Categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;



}
