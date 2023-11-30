package com.simple.item.repository

import com.simple.item.repository.entity.HashTag
import org.springframework.data.jpa.repository.JpaRepository

interface HashTagRepository : JpaRepository<HashTag, String>