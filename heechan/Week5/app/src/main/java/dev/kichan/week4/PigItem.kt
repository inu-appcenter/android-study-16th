package dev.kichan.week4

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class PigItem(
    val excman: String,
    val nes_cn: String,
    val nes_ymd: String
) {
    val date: LocalDate
        @RequiresApi(Build.VERSION_CODES.O)
        get() = LocalDate.parse(
            this.nes_ymd,
            DateTimeFormatter.ofPattern("yyyyMMdd")!!
        )
}