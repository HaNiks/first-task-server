package com.balinasoft.firsttask.controller.api2;

import com.balinasoft.firsttask.dto.CommentDtoOut;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.service.api2.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import static com.balinasoft.firsttask.system.StaticWrapper.wrap;

@RestController
@RequestMapping("/api/v2/category")
@Api(tags = "Categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ApiOperation(value = "Add category", response = CommentDtoOut.class)
    public ResponseDto add(@RequestBody CategoryDTOIn categoryDTOIn) {
        return wrap(categoryService.save(categoryDTOIn));
    }

    @GetMapping
    @ApiOperation(value = "Find all categories")
    public ResponseDto findAll(@RequestParam(defaultValue = "0", required = false) int page) {
        return wrap(categoryService.findAll(page));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find category by id")
    public ResponseDto findById(@PathVariable int id) {
        return wrap(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete category", response = CategoryDTOOut.class)
    public ResponseDto delete(@PathVariable int id) {
        categoryService.delete(id);
        return wrap();
    }

}
