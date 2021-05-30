package com.example.youtubeapi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout : Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        showDisconnectState() // метод который отображает подкл к интернету // сделать абстрактным
        // для того что бы можно было вызвать с любого активити
        setupLiveData() // обсерверы и т.д.
        setupUI() // инициализация всех ui элементов вкл адаптер
    }

    abstract  fun setupLiveData()

    abstract fun setupUI()

    abstract fun showDisconnectState()

}