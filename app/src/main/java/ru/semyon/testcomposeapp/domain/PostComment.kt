package ru.semyon.testcomposeapp.domain

import ru.semyon.testcomposeapp.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.ic_sigur_smartzhk_design,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)