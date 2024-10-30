package com.example.halloween

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.halloween.models.Persona

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val personas = listOf(
            Persona("Angel", 22, 170),
            Persona("Raul", 4, 50),
            Persona("Carmen", 40, 150),
            Persona("Fernando", 15, 180),
            Persona("Fernando", 15, 180),
            Persona("Fernando", 15, 180),
            Persona("Fernando", 15, 180),
        )

        val sustos = setOf("\uD83C\uDF83", "\uD83D\uDC7B", "\uD83D\uDC80", "🕷️", "🕸️", "🦇")
        val dulces = setOf("🍰", "🍬", "🍦", "🍭", "🍪", "🍫", "🧁", "🍩")

        val txt: TextView = findViewById(R.id.textView)
        val truco: Button = findViewById(R.id.truco)
        val trato: Button = findViewById(R.id.trato)

        truco.setOnClickListener {
            var count = 0
            var alturaTotal = 0
            personas.forEach { persona ->
                count += persona.nombre.length / 2
                if (persona.edad % 2 == 0) count += 2
                alturaTotal += persona.altura
            }

            count += alturaTotal / 100
            var res = ""
            for (i in 1..count) {
                res += sustos.random()
            }
            txt.text = res
        }

        trato.setOnClickListener{
            var count = 0
            personas.forEach { persona ->
                count += persona.nombre.length
                val trios: Int = persona.edad / 3
                count += if (trios > 3) 3 else trios
                val medioMetro: Int = persona.altura / 50
                count += if (medioMetro > 3) 3 else medioMetro
            }

            var res = ""
            for (i in 1..count) {
                res += dulces.random()
            }
            txt.text = res
        }
    }
}