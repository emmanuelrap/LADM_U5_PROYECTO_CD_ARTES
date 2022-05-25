package com.example.ladm_u3_tarea2_googlemaps

import android.graphics.Bitmap
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crearFragment()
    }

    private fun crearFragment() {
        val mapFragment=supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        map=p0
       crearMarcador()
    }

    private fun crearMarcador() {
        val coordenadasPrincipales = LatLng(21.51108496011311, -104.90307329600743)

        val jardinDignidad=MarkerOptions().position(LatLng(21.512381454724817, -104.90404305341924)).title("Jardín de la Dignidad")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            .snippet("Parque")


        val cdArtes=MarkerOptions().position(LatLng(21.51103975981268, -104.90306478583207)).title("Ciudad de las Artes")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            .snippet("Parque")

        val afterTacos=MarkerOptions().position(LatLng(21.51165095509239, -104.90403546698616)).title("Tacos El After")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            .snippet("Alimentos")

        val skatePark=MarkerOptions().position(LatLng(21.51197562204376, -104.9027154276223)).title("Skate Park")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            .snippet("Zona Recreativa")

        val estatuas=MarkerOptions().position(LatLng(21.510740472140885, -104.90317061360524)).title("Estatuas Conmemorativas")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            .snippet("Zona Conmemorativa")

        val escuelaMusica=MarkerOptions().position(LatLng(21.511986208992873, -104.90210851297405)).title("Escuela de Musica")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
            .snippet("Istitución")

        val zonaTacos =MarkerOptions().position(LatLng(    21.51091873667444, -104.9037786567254)).title("Zona de Tacos")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            .snippet("Alimentos")

        val dolores =MarkerOptions().position(LatLng(    21.510396830580504, -104.90331087782104)).title("Dolores")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
            .snippet("Alimentos")

        val laSanta =MarkerOptions().position(LatLng(    21.510330049125745, -104.90314384918146)).title("La Santa")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
            .snippet("Bar")

        val cremeria =MarkerOptions().position(LatLng(    21.51248992670049, -104.90184382014519)).title("Cremeria Yoli")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            .snippet("Negocio")

        map.setOnMapClickListener {
            Toast.makeText(this,"Clic en el Mapa",Toast.LENGTH_SHORT).show()
        }





        map.addMarker(cdArtes)
        map.addMarker(jardinDignidad)
        map.addMarker(afterTacos)
        map.addMarker(skatePark)
        map.addMarker(escuelaMusica)
        map.addMarker(estatuas)
        map.addMarker(dolores)
        map.addMarker(zonaTacos)
        map.addMarker(laSanta)
        map.addMarker(cremeria)

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordenadasPrincipales,18f),3000,null //Cuanto zoom y cuando durarà
        )
    }


}