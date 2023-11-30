package com.simple.item.repository

import com.simple.item.repository.entity.Item
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ItemRepository : JpaRepository<Item, Int> {
    override fun findAll(pageable: Pageable): Page<Item>

    @EntityGraph(attributePaths = ["category", "hashTage"])
    fun findAll(itemSpec: Specification<Item>, pageable: Pageable): Page<Item>

    @EntityGraph(attributePaths = ["category", "hashTage"])
    override fun findById(id: Int): Optional<Item>
}
