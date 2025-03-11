package com.example.juegoparejas

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //<editor-fold desc="IMAGENES GUI">
    lateinit var iv_11:ImageView
    lateinit var iv_12:ImageView
    lateinit var iv_13:ImageView
    lateinit var iv_14:ImageView

    lateinit var iv_21:ImageView
    lateinit var iv_22:ImageView
    lateinit var iv_23:ImageView
    lateinit var iv_24:ImageView

    lateinit var iv_31:ImageView
    lateinit var iv_32:ImageView
    lateinit var iv_33:ImageView
    lateinit var iv_34:ImageView
    //</editor_fold>

    //<editor-fold desc="OTROS GUI">
    lateinit var tv_j1:TextView
    lateinit var tv_j2:TextView

    lateinit var ib_sonido:ImageButton

    lateinit var mp: MediaPlayer
    lateinit var mpFondo: MediaPlayer
    lateinit var imagen1: ImageView
    lateinit var imagen2: ImageView

    //</editor_fold>

    //<editor-fold desc="VARIABLES GUI">
    var imagenesArray = arrayOf(11,12,13,14,15,16,21,22,23,24,25,26)
    var mario = 0
    var luigi = 0
    var toad = 0
    var peach = 0
    var yoshi = 0
    var wario = 0

    var turno = 1
    var puntosj1 = 0
    var puntosj2 = 0
    var numeroImagen = 1
    var escuchar = true
    //</editor_fold>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        enlazarGUI()
        }

    private fun enlazarGUI() {
        iv_11 = findViewById(R.id.iv_11)
        iv_12 = findViewById(R.id.iv_12)
        iv_13 = findViewById(R.id.iv_13)
        iv_14 = findViewById(R.id.iv_14)
        iv_21 = findViewById(R.id.iv_21)
        iv_22 = findViewById(R.id.iv_22)
        iv_23 = findViewById(R.id.iv_23)
        iv_24 = findViewById(R.id.iv_24)
        iv_31 = findViewById(R.id.iv_31)
        iv_32 = findViewById(R.id.iv_32)
        iv_33 = findViewById(R.id.iv_33)
        iv_34 = findViewById(R.id.iv_34)

        ib_sonido = findViewById(R.id.ib_sonido)
        ib_sonido.setColorFilter(Color.GREEN)
        sonido("background",true)

        iv_11.tag = "0"
        iv_12.tag = "1"
        iv_13.tag = "2"
        iv_14.tag = "3"
        iv_21.tag = "4"
        iv_22.tag = "5"
        iv_23.tag = "6"
        iv_24.tag = "7"
        iv_31.tag = "8"
        iv_32.tag = "9"
        iv_33.tag = "10"
        iv_34.tag = "11"

        mario = R.drawable.mario
        luigi = R.drawable.luigi
        yoshi = R.drawable.yoshi
        toad = R.drawable.toad
        peach = R.drawable.peach
        wario = R.drawable.wario

        imagenesArray.shuffle()

        tv_j1 = findViewById(R.id.tv_j1)
        tv_j2 = findViewById(R.id.tv_j2)

        tv_j2.setTextColor(Color.GRAY)
        tv_j1.setTextColor(Color.WHITE)


    }

    private fun sonido(sonidoName: String, loop: Boolean=false) {
        var resID = resources.getIdentifier(
            sonidoName, "raw",packageName
        )
        if(sonidoName=="background"){
            mpFondo = MediaPlayer.create(this, resID)
            mpFondo.isLooping = loop
            mpFondo.setVolume(0.04F, 0.04F)
            if(!mpFondo.isPlaying){
                mpFondo.start()
            }
        } else {
            mpFondo = MediaPlayer.create(this, resID)
            mpFondo.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                mediaPlayer -> mediaPlayer.stop()
                mediaPlayer.release()
            })
            if(!mp.isPlaying){
                mp.start()
            }
        }
    }
}
