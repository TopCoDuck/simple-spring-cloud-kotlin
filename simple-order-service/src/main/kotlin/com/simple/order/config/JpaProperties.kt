package com.simple.order.config

class JpaProperties(showSql: String, formatSql: String, useSqlComments: String) : HashMap<String, Any>() {
    init {
        put("hibernate.show_sql", showSql)
        put("hibernate.format_sql", formatSql)
        put("hibernate.use_sql_comments", useSqlComments)
        put("hibernate.physical_naming_strategy",
            "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy")
    }
}
