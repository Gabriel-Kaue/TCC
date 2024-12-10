package view.pages.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.core.graphics.values
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields

@Composable
fun Calendario() {
    val currentMonth by remember { mutableStateOf(YearMonth.now()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Month header
        Text(
            text = currentMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Days of the week header
        Row {
            for (dayOfWeek in DayOfWeek.values()) {
                Text(
                    text = dayOfWeek.getDisplayName(
                        java.time.format.TextStyle.SHORT,
                        java.util.Locale.getDefault()
                    ),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                )
            }
        }

        // Calendar grid
        val daysInMonth = currentMonth.lengthOfMonth()
        val firstDayOfMonth = LocalDate.of(currentMonth.year, currentMonth.month, 1)
        val firstDayOfWeek =
            firstDayOfMonth.dayOfWeek.value % 7 // Adjust for Sunday as the first day of the week
        val weekFields = WeekFields.of(java.util.Locale.getDefault())
        val totalWeeks = currentMonth.atEndOfMonth().get(weekFields.weekOfMonth())

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items((1..totalWeeks * 7).toList()) { dayIndex ->
                val day = dayIndex - firstDayOfWeek
                if (day in 1..daysInMonth) {
                    val date = LocalDate.of(currentMonth.year, currentMonth.month, day)
                    CalendarDay(date, isCurrentDay = date == LocalDate.now())
                } else {
                    Spacer(modifier = Modifier.size(0.dp)) // Empty space for days outside the current month
                }
            }
        }
    }
}

@Composable
fun CalendarDay(date: LocalDate, isCurrentDay: Boolean) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(if (isCurrentDay) Color.LightGray else Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Text(text = date.dayOfMonth.toString())
    }
}

@Preview
@Composable
fun PreviewCalendario() {
    Calendario()
}