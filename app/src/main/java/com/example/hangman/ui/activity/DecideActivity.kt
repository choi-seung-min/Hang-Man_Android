package com.example.hangman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.hangman.R
import com.example.hangman.contract.DecideContract
import com.example.hangman.presenter.DecidePresenter
import kotlinx.android.synthetic.main.activity_decide.*

class DecideActivity : AppCompatActivity(), View.OnClickListener, DecideContract.View {
    private lateinit var presenter: DecidePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decide)

        presenter = DecidePresenter(this)

        initViewListener()
    }

    private fun initViewListener() {
        tv_kb_a.setOnClickListener(this)
        tv_kb_b.setOnClickListener(this)
        tv_kb_c.setOnClickListener(this)
        tv_kb_d.setOnClickListener(this)
        tv_kb_e.setOnClickListener(this)
        tv_kb_f.setOnClickListener(this)
        tv_kb_g.setOnClickListener(this)
        tv_kb_h.setOnClickListener(this)
        tv_kb_i.setOnClickListener(this)
        tv_kb_j.setOnClickListener(this)
        tv_kb_k.setOnClickListener(this)
        tv_kb_l.setOnClickListener(this)
        tv_kb_m.setOnClickListener(this)
        tv_kb_n.setOnClickListener(this)
        tv_kb_o.setOnClickListener(this)
        tv_kb_p.setOnClickListener(this)
        tv_kb_q.setOnClickListener(this)
        tv_kb_r.setOnClickListener(this)
        tv_kb_s.setOnClickListener(this)
        tv_kb_t.setOnClickListener(this)
        tv_kb_u.setOnClickListener(this)
        tv_kb_v.setOnClickListener(this)
        tv_kb_w.setOnClickListener(this)
        tv_kb_x.setOnClickListener(this)
        tv_kb_y.setOnClickListener(this)
        tv_kb_z.setOnClickListener(this)
        // 각각 스펠링 TextView OnClick

        btn_submit.setOnClickListener(this)
        btn_delete.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_submit) {
            presenter.checkLetterCount(ed_Questions_word.length())
        } else if (view?.id == R.id.btn_delete) {
            presenter.onClickDeleteButton(ed_Questions_word.text.toString())
        } else if (view is TextView?) {
            if (ed_Questions_word.length() < 10) presenter.alphabetsOnClick(view?.text.toString())
        }
    }

    override fun appendText(appendText: String) {
        val text = "${ed_Questions_word.text}$appendText"
        ed_Questions_word.setText(text)
    }

    override fun setEditText(text: String) {
        ed_Questions_word.setText(text)
    }

    override fun errorToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun buttonAnimation() {
        val shack: Animation = AnimationUtils.loadAnimation(this, R.anim.dicide_an_error)
        btn_submit.startAnimation(shack)
    }
}