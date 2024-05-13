package com.example.tfg_app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tfg_app.domain.models.DataExample
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer

@Composable
fun StatsScreen(paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Periodic Resume",
            fontSize = 34.sp,
            modifier = Modifier.padding(top = 40.dp)
        )
        val data = listOf(
            DataExample("Enero",2.0),
            DataExample("Febrero",1.5),
            DataExample("Marzo",1.3),
            DataExample("Abril",2.5),
            DataExample("Mayo",2.0)
        )

        Bars(data)
        Lines(data)
    }

}

@Composable
fun Bars(dataExample: List<DataExample>) {
    val bars = ArrayList<BarChartData.Bar>()
    dataExample.mapIndexed { index, datos ->
        bars.add(
            BarChartData.Bar(
                label = datos.label,
                value = datos.value.toFloat(),
                color = Color.Blue
            )
        )
    }
    BarChart(
        barChartData = BarChartData(
            bars = bars
        ),
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 80.dp)
            .height(300.dp),
        labelDrawer = SimpleValueDrawer(
            drawLocation = SimpleValueDrawer.DrawLocation.XAxis
        )
    )
}

@Composable
fun Lines(dataExample: List<DataExample>) {
    val points = ArrayList<LineChartData.Point>()
    dataExample.mapIndexed { index, datos ->
        points.add(LineChartData.Point(
            value = datos.value.toFloat(),
            label = datos.label
        ))
    }
    val lines = ArrayList<LineChartData>()
    lines.add(
        LineChartData(
            points = points,
            lineDrawer = SolidLineDrawer()
        )
    )
    LineChart(
        linesChartData = lines,
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 80.dp)
            .height(300.dp),
    )
}