package br.com.playmetrics.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.playmetrics.R
import br.com.playmetrics.dao.TeamDao
import br.com.playmetrics.ui.recyclerview.adapter.ListTeamAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListTeamActivity : AppCompatActivity(R.layout.activity_list_team) {

    private val teamDao =  TeamDao()

    private val adapter = ListTeamAdapter(context = this, teamDao.findAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo", Toast.LENGTH_SHORT).show()
        configRecycleView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(teamDao.findAll())
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            startActivity(Intent(this, FormTeamActivity::class.java))
        }
    }

    private fun configRecycleView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

}