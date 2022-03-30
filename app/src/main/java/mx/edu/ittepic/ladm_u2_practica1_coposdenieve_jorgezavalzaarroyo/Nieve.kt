package mx.edu.ittepic.ladm_u2_practica1_coposdenieve_jorgezavalzaarroyo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Nieve( l:Lienzo ) {
    val l = l
    var x = 0f
    var y = 0f
    var movY = 0f
    var tamaño = 1f

    init {
        x = rand(1080)
        tamaño = rand(10)
        if ( tamaño <= 4 ) {
            movY = 7f
        } else {
            if ( tamaño > 4 && tamaño < 7 ) {
                movY = 4f
            } else {
                movY = 2f
            }
        }
    }

    private fun rand( hasta:Int ) : Float {
        return Random.nextInt(hasta).toFloat()
    }

    fun mover() {
        y += movY
        if ( y >= 2022f ) {
            y = 0f
            x = rand(1080)
        }
    }

    fun pintar ( canvas: Canvas ) {
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(x, y, tamaño, p)
    }
}