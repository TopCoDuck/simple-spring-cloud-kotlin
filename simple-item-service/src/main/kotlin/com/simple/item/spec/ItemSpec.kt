package com.simple.item.spec

import com.simple.item.repository.entity.Item
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification


class ItemSpec : Specification<Item> {
    private var searchType: String? = null
    private var searchValue: String? = null

    protected constructor()
    constructor(searchType: String?, searchValue: String?) {
        this.searchType = searchType
        this.searchValue = searchValue
    }

    override fun toPredicate(root: Root<Item>, query: CriteriaQuery<*>, cb: CriteriaBuilder): Predicate {
        return when (searchType) {
            "NAME" -> cb.like(root.get("itemNm"), "%$searchValue%")
            "DESC" -> cb.like(root.get("itemDesc"), "%$searchValue%")
            else -> cb.or(
                cb.like(root.get("itemNm"), "%$searchValue%"), cb.like(root.get("itemDesc"), "%$searchValue%")
            )
        }
    }
}
