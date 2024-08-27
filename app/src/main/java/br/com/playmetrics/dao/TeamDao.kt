package br.com.playmetrics.dao

import br.com.playmetrics.model.Team

class TeamDao {

    fun save(team: Team){
        Companion.teams.add(team)

    }

    fun findAll() : List<Team>{
        return Companion.teams.toList()
    }

    companion object {
        private val teams = mutableListOf<Team>()
    }


}