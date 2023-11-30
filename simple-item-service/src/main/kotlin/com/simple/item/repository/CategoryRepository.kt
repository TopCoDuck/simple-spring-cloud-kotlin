package com.simple.item.repository

import com.simple.item.repository.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, String>