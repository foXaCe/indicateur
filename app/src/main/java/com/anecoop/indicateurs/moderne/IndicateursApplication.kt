package com.anecoop.indicateurs.moderne

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class IndicateursApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Appliquer le thème sauvegardé au démarrage de l'app
        val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val theme = prefs.getInt("theme", 0)
        
        val mode = when (theme) {
            1 -> AppCompatDelegate.MODE_NIGHT_NO
            2 -> AppCompatDelegate.MODE_NIGHT_YES
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}
