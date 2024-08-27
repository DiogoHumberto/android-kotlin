package br.com.playmetrics.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.playmetrics.R
import br.com.playmetrics.model.Team

class ListTeamAdapter(
    private val context: Context,
    teams: List<Team>
) : RecyclerView.Adapter<ListTeamAdapter.ViewHolder>() {

    private val teams = teams.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(team: Team) {
            val name = itemView.findViewById<TextView>(R.id.nome)
            name.text = team.name

            val desc = itemView.findViewById<TextView>(R.id.descricao)
            desc.text = team.desc

            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = team.amount.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view= inflater.inflate(R.layout.team, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
       val team = teams[position]
        holder.vincula(team)
    }

    fun update(teams: List<Team>) {
        this.teams.clear()
        this.teams.addAll(teams)
        notifyDataSetChanged()

    }

}
