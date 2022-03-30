package mx.edu.ittepic.ladm_u2_practica1_coposdenieve_jorgezavalzaarroyo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo( este:MainActivity ) : View(este) {
    val este = este
    var copos = ArrayList<Nieve>()
    var cantidad = 0
    var count = 0

    val corrutina = GlobalScope.launch {
        while ( true ) {
            este.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }
    val corrutina2 = GlobalScope.launch {
        while ( true ) {
            este.runOnUiThread {
                count++
            }
            delay(100L)
        }
    }


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        // Colores
        val tronco = Color.rgb(97, 99, 49)
        val hoja1 = Color.rgb(143, 10, 5)
        val hoja2 = Color.rgb(245, 130, 55)
        val hoja3 = Color.rgb(140, 153, 24)
        val hoja4 = Color.rgb(249, 182, 62)
        val hoja5 = Color.rgb(255, 232, 58)
        val hoja6 = Color.rgb(175, 187, 39)
        val pasto1 = Color.rgb(68, 101, 40)
        val pasto2 = Color.rgb(89, 119, 48)
        val cielo = Color.rgb(14, 42, 79)
        val nube = Color.rgb(44, 72, 112)
        val luna = Color.rgb(237, 237, 237)

        // Cielo
        c.drawColor(cielo)

        // Luna
        p.color = luna
        c.drawCircle(700f, 470f,130f, p)

        // Nube
        p.color = nube
        c.drawCircle(780f, 640f, 100f, p)
        c.drawCircle(830f, 580f, 80f, p)
        c.drawCircle(800f, 500f, 40f, p)
        c.drawCircle(750f, 540f, 60f, p)
        c.drawCircle(680f, 580f, 50f, p)
        c.drawCircle(630f, 620f, 40f, p)
        c.drawCircle(680f, 620f, 40f, p)
        c.drawCircle(580f, 640f, 30f, p)
        c.drawCircle(580f, 640f, 30f, p)
        p.color = cielo
        c.drawRect(550f,640f,1140f,740f,p)

        // Colinas
        p.color = pasto1
        c.drawCircle(-100f, 2422f, 1000f, p)            // Colina 1

        p.color = pasto2
        c.drawCircle(900f, 2522f, 1000f, p)             // Colina 2

        // Arbolitos
        p.color = tronco
        c.drawRect(200f, 1300f, 240f, 1600f, p) // Arbol 1
        p.color = hoja6
        c.drawCircle(220f, 1250f, 60f, p)
        p.color = hoja1
        c.drawCircle(280f, 1400f, 90f, p)
        p.color = hoja2
        c.drawCircle(160f, 1360f, 90f, p)
        p.color = hoja3
        c.drawCircle(250f, 1320f, 80f, p)
        p.color = hoja4
        c.drawCircle(180f, 1290f, 70f, p)
        p.color = hoja5
        c.drawCircle(190f, 1400f, 70f, p)

        p.color = tronco
        c.drawRect(900f, 1600f, 940f, 1900f, p) // Arbol 2
        p.color = hoja1
        c.drawCircle(920f, 1550f, 60f, p)
        p.color = hoja6
        c.drawCircle(980f, 1700f, 90f, p)
        p.color = hoja5
        c.drawCircle(860f, 1660f, 90f, p)
        p.color = hoja4
        c.drawCircle(950f, 1620f, 80f, p)
        p.color = hoja3
        c.drawCircle(880f, 1590f, 70f, p)
        p.color = hoja2
        c.drawCircle(890f, 1700f, 70f, p)

        p.color = tronco
        c.drawRect(550f, 1500f, 590f, 1800f, p) // Arbol 3
        p.color = hoja5
        c.drawCircle(570f, 1450f, 60f, p)
        p.color = hoja6
        c.drawCircle(630f, 1600f, 90f, p)
        p.color = hoja3
        c.drawCircle(510f, 1560f, 90f, p)
        p.color = hoja2
        c.drawCircle(600f, 1520f, 80f, p)
        p.color = hoja4
        c.drawCircle(530f, 1490f, 70f, p)
        p.color = hoja1
        c.drawCircle(540f, 1600f, 70f, p)


        p.color = tronco
        c.drawRect(280f, 1700f, 320f, 2000f, p) // Arbol 4
        p.color = hoja5
        c.drawCircle(300f, 1650f, 60f, p)
        p.color = hoja4
        c.drawCircle(360f, 1800f, 90f, p)
        p.color = hoja1
        c.drawCircle(240f, 1760f, 90f, p)
        p.color = hoja3
        c.drawCircle(330f, 1720f, 80f, p)
        p.color = hoja2
        c.drawCircle(260f, 1690f, 70f, p)
        p.color = hoja6
        c.drawCircle(270f, 1800f, 70f, p)

        // Nieve
        for ( snow in copos ) {
            snow.mover()
            snow.pintar(c)
        }

        if ( count == 10 ) {
            count = 0
            copos.add(Nieve(this))
        }

    }
}