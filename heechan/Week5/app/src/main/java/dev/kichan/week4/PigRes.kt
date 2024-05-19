package dev.kichan.week4

data class PigRes(
    val items: List<PigItem>,
    val numOfRows: String,
    val pageNo: String,
    val resultCode: String,
    val resultMsg: String,
    val totalCount: String
)