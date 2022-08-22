package com.balinasoft.firsttask.controller.api2;

import com.balinasoft.firsttask.dto.CommentDtoOut;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.service.api2.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import static com.balinasoft.firsttask.system.StaticWrapper.wrap;

@RestController
@RequestMapping("/api/v2/category")
@Api(tags = "Categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @PostMapping
    @ApiOperation(value = "Add category", response = CommentDtoOut.class)
    public ResponseDto add(@RequestBody CategoryDTOIn categoryDTOIn) {
        return wrap(categoryServiceImpl.save(categoryDTOIn));
    }

    @GetMapping
    @ApiOperation(value = "Find all categories")
    public Page<CategoryDTOOut> findAll(@RequestParam(defaultValue = "0", required = false) int page) {
        return categoryServiceImpl.findAll(page);
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Find category by name")
    public CategoryDTOOut findByName(@PathVariable String name) {
        return categoryServiceImpl.findByName(name);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete category", response = CategoryDTOOut.class)
    public ResponseDto delete(@PathVariable int id) {
        categoryServiceImpl.delete(id);
        return wrap();
    }

}
