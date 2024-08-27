package br.com.playmetrics.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.playmetrics.R
import br.com.playmetrics.dao.TeamDao
import br.com.playmetrics.model.Team
import java.math.BigDecimal

class FormTeamActivity : AppCompatActivity(R.layout.activity_form_team) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        configButtonSave()
    }

    private fun configButtonSave() {
        val buttonSave = findViewById<Button>(R.id.botao_salvar)
        buttonSave.setOnClickListener {
            val team = team()
            TeamDao().save(team)
            finish()
        }
    }

    private fun team(): Team {
        val campoNome = findViewById<EditText>(R.id.name)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.amount)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) BigDecimal.ZERO else BigDecimal(valorEmTexto)

       return Team(
            name = nome,
            desc = descricao,
            amount = valor
        )
    }
}