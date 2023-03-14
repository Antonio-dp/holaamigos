package com.example.examenu2
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class detalles: AppCompatActivity(){
    var adapter: DetalleAdapter?=null
    var regalos = ArrayList<Detalle>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        cargarDetalles()

        adapter = DetalleAdapter(regalos,this)
        var gridRegalos: GridView = findViewById(R.id.grid_detalles)

        gridRegalos.adapter = adapter

    }

    fun cargarDetalles(){
        regalos.add(Detalle(R.drawable.pelucheminecraft, "Peluche Minecraft", "$10"))
        regalos.add(Detalle(R.drawable.peluchemario, "Peluche Mario", "$12"))
        regalos.add(Detalle(R.drawable.peluchepeppa, "Peluche Peppa", "$15"))
        regalos.add(Detalle(R.drawable.peluchesony, "Peluche Sonic", "$18"))
        regalos.add(Detalle(R.drawable.peluchestich, "Peluche Stich", "$21"))
    }
    class DetalleAdapter: BaseAdapter{
        var regalos = ArrayList<Detalle>()
        var contexto: Context? = null

        constructor(regalos: ArrayList<Detalle>, context: Context):super(){
           this.regalos=regalos
           this.contexto=context
        }

        override fun getCount(): Int {
            return regalos.size
        }

        override fun getItem(position: Int): Any {
            return regalos[0]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var regalo = regalos[position]
            var inflador = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflador.inflate(R.layout.regalos,null)
            var imagen = vista.findViewById(R.id.iv_imagen) as ImageView
            var nombre = vista.findViewById(R.id.tv_nombre) as TextView

            imagen.setImageResource(regalo.image)
            nombre.setText(regalo.titulo)

            vista.setOnClickListener{
                var intent = Intent(contexto,detalleRegalos::class.java)
                intent.putExtra("nombre", regalo.titulo)
                intent.putExtra("imagen", regalo.image)
                intent.putExtra("precio", regalo.precio)
                contexto!!.startActivity(intent)
            }

            return vista
        }
    }
}