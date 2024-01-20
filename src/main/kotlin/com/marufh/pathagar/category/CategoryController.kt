package com.marufh.pathagar.category

import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(CategoryController.CATEGORY_API)
class CategoryController(val categoryService: CategoryService) {

    companion object {
        const val CATEGORY_API = "/api/user/categories"
    }

    @GetMapping("/{id}")
    fun getAuthorDetails(@PathVariable id: String): CategoryDto {
      return categoryService.getDetails(id)
    }

    @GetMapping
    fun getAll(@RequestParam(required = false) search: String?, pageable: Pageable) = ResponseEntity
        .ok(categoryService.findAll(search, pageable));

}