package view.pages.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendario(
    navController: NavHostController
) {
    val currentMonth by remember { mutableStateOf(YearMonth.now()) }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "Voltar"
                    )
                }
            })
    }) { innerPadding -> // Use o innerPadding aqui

        Column(
            modifier = Modifier
                .padding(innerPadding) // Use o innerPadding aqui
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


            Row {
                for (dayOfWeek in DayOfWeek.entries) {
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
                        CalendarDay(date = date, isCurrentDay = date == LocalDate.now()) // Use os paramentros corretamente
                    } else {
                        Spacer(modifier = Modifier.size(0.dp)) // Empty space for days outside the current month
                    }
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

