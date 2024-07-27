package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.quotesapp.screen.QuoteListScreen
import com.example.quotesapp.screen.QuotesDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataManager.loadAssetsFromFile(this)
        setContent {

            App()
        }

    }

    @Composable
    fun App() {

        if (DataManager.isDataLoaded.value) {

            if (DataManager.currentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)

                }


            } else {
                DataManager.currentQuot?.let { QuotesDetail(quote = it) }
            }
        }
    }


}

enum class Pages {
    LISTING,
    DETAIL
}



