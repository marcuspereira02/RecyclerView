package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = ContactListAdapter()
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this,2)
        }

        ivList.setOnClickListener{
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener {contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }

    }
}

private val contacts = listOf(
    Contact(
        name = "Kiara",
        phone = "(55) 12 987479983",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Francisco",
        phone = "(55) 12 987479477",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Julia",
        phone = "(55) 11 987409498",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Ana Júlia",
        phone = "(55) 12 997426902",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Amanda",
        phone = "(55) 11 993479642",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Paula",
        phone = "(55) 12 997379497",
        icon = R.drawable.sample6
    ),
    Contact(
        name ="Mônica",
        phone = "(55) 11 987620194",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "Théo",
        phone = "(55) 12 998450251",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Anthony",
        phone = "(55) 12 997320648",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Bruno",
        phone = "(55) 12 992784017",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Yasmin",
        phone = "(55) 12 990398173",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Nicolas",
        phone = "(55) 12 984920173",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Maria Eduarda",
        phone = "(55) 12 986241083",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Danilo",
        phone = "(55) 11 998630297",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Gisele",
        phone = "(55) 12 996302918",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Gabriela",
        phone = "(55) 11 997201983",
        icon = R.drawable.sample16
    )
)