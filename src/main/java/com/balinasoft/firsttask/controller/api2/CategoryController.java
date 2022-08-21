package com.balinasoft.firsttask.controller.api2;

import com.balinasoft.firsttask.dto.CommentDtoOut;
import com.balinasoft.firsttask.dto.ResponseDto;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.service.api2.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import static com.balinasoft.firsttask.system.StaticWrapper.wrap;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/v2/category")
@Api(tags = "Categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "", method = POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Add category", response = CommentDtoOut.class)
    public ResponseDto add(@RequestBody CategoryDTOIn categoryDTOIn) {
        return wrap(categoryService.save(categoryDTOIn));
    }

    @RequestMapping(value = "", method = GET)
    @ApiOperation(value = "Find all categories")
    public Page<CategoryDTOOut> findAll(@RequestParam(defaultValue = "0", required = false) int page) {
        return categoryService.findAll(page);
    }

    @RequestMapping(value = "name", method = GET)
    @ApiOperation(value = "Find category by name")
    public CategoryDTOOut findByName(@RequestParam String name) {
        return categoryService.findByName(name);
    }

    @RequestMapping(value = "{categoryId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete category", response = CategoryDTOOut.class)
    public ResponseDto delete(@PathVariable int categoryId) {
        categoryService.delete(categoryId);
        return wrap();
    }

}
