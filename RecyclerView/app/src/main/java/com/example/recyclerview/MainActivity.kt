package com.example.recyclerview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList(), this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,RecyclerView.VERTICAL))
    }

    private fun fetchList(): ArrayList<ColorData> {
        return arrayListOf(
            ColorData("WHITE", Color.WHITE),
            ColorData("BLACK", Color.BLACK),
            ColorData("BLUE", Color.BLUE),
            ColorData("RED", Color.RED),
            ColorData("MAGENTA", Color.MAGENTA)
        )

    }

    class ColorData {
        constructor(name: String, hex: Int) {
            colorName = name
            colorHex = hex
        }

        val colorName: String
        val colorHex: Int
    }

    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this,"IT'S ${data.colorName}", Toast.LENGTH_SHORT).show()
    }
}
interface CellClickListener {
    fun onCellClickListener(data: MainActivity.ColorData)
}