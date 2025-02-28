package com.example.hangman.contract

import android.widget.TextView

interface DecideContract {
    interface View {
        fun appendText(appendText : String)
        fun errorToast(text : String)
        fun buttonAnimation()
        fun setEditText(text : String)
    }

    interface Presenter {
        fun alphabetsOnClick(text : String)
        fun onClickDeleteButton(text : String)
        fun checkLetterCount(length : Int)
    }
}