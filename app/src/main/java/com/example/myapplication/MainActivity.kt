package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var tvText: TextView
    private lateinit var tvName: TextView
    private lateinit var tvWinner: TextView
    private lateinit var tvMmora: TextView
    private lateinit var tvCmora: TextView
    private lateinit var btnScissor: RadioButton
    private lateinit var btnStone: RadioButton
    private lateinit var btnPaper: RadioButton
    private lateinit var btnMora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.edname)

        tvText = findViewById(R.id.tvtext)
        tvName = findViewById(R.id.tvname)
        tvWinner = findViewById(R.id.tvwinner)
        tvMmora = findViewById(R.id.tvmmora)
        tvCmora = findViewById(R.id.tvcmora)

        btnScissor = findViewById(R.id.btnscissor)
        btnStone = findViewById(R.id.btnstone)
        btnPaper = findViewById(R.id.btnpaper)

        btnMora = findViewById(R.id.btnmora)

        btnMora.setOnClickListener {
            if (edName.length() < 1) {
                tvText.text = "請輸入玩家姓名"
            } else {
                tvName.text = "名字\n${edName.text}"

                when {
                    btnScissor.isChecked -> tvMmora.text = "我方出拳\n剪刀"
                    btnStone.isChecked -> tvMmora.text = "我方出拳\n石頭"
                    else -> tvMmora.text = "我方出拳\n布"
                }

                val computerRandom = (0..2).random()

                when (computerRandom) {
                    0 -> tvCmora.text = "電腦出拳\n剪刀"
                    1 -> tvCmora.text = "電腦出拳\n石頭"
                    else -> tvCmora.text = "電腦出拳\n布"
                }

                when {
                    (btnScissor.isChecked && computerRandom == 2) ||
                            (btnStone.isChecked && computerRandom == 0) ||
                            (btnPaper.isChecked && computerRandom == 1) -> {
                        tvWinner.text = "勝利者\n${edName.text}"
                        tvText.text = "恭喜您獲勝了！！！"
                    }
                    (btnScissor.isChecked && computerRandom == 1) ||
                            (btnStone.isChecked && computerRandom == 2) ||
                            (btnPaper.isChecked && computerRandom == 0) -> {
                        tvWinner.text = "勝利者\n電腦"
                        tvText.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        tvWinner.text = "勝利者\n平手"
                        tvText.text = "平局，請再試一次！"
                    }
                }
            }
        }
    }
}
