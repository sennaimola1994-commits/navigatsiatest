
package pl.trucknavipl.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private val backgroundColor = Color.rgb(18, 23, 30)
    private val panelColor = Color.rgb(30, 38, 48)
    private val accentColor = Color.rgb(45, 150, 220)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(backgroundColor)
            setPadding(18, 24, 18, 18)
        }

        val title = TextView(this).apply {
            text = "TRUCK NAVI PL"
            textSize = 25f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Профессиональная навигация для грузовиков"
            textSize = 13f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val mapPanel = TextView(this).apply {
            text = "КАРТА ПОЛЬШИ\n\nЗдесь будет отображаться карта и маршрут"
            textSize = 18f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setBackgroundColor(panelColor)
        }

        val routeButton = createButton("ПОСТРОИТЬ МАРШРУТ")
        val baseButton = createButton("МОЯ БАЗА")
        val vehicleButton = createButton("ПРОФИЛЬ ГРУЗОВИКА")
        val settingsButton = createButton("НАСТРОЙКИ")

        root.addView(title)
        root.addView(subtitle)

        root.addView(
            mapPanel,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            ).apply {
                setMargins(0, 24, 0, 20)
            }
        )

        root.addView(routeButton)
        root.addView(baseButton)
        root.addView(vehicleButton)
        root.addView(settingsButton)

        setContentView(root)
    }

    private fun createButton(label: String): Button {
        return Button(this).apply {
            text = label
            textSize = 14f
            setTextColor(Color.WHITE)
            setBackgroundColor(accentColor)

            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                58
            ).apply {
                setMargins(0, 5, 0, 5)
            }
        }
    }
}
