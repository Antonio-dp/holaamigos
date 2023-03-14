package com.example.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class detalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val iv_imagen_detalle: ImageView = findViewById(R.id.iv_imagen)
        val tv_nombre_regalo: TextView = findViewById(R.id.tv_nombre)
        val tv_precio_regalo: TextView = findViewById(R.id.tv_precio)

        val bundle = intent.extras
        if(bundle!=null){
            iv_imagen_detalle.setImageResource(bundle.getInt("imagen"))
            tv_nombre_regalo.setText(bundle.getString("nombre"))
            tv_precio_regalo.setText(bundle.getString("precio"))
        }
    }
}