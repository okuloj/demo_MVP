package com.example.demo_mvp.data.source.remote.fetchJson

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.Toast
import com.example.demo_mvp.screen.MainActivity
import com.example.demo_mvp.utils.Constant
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class GetDataFromUrl {
    fun getDataFromUrl(url: String): String? {
        var urlConn: HttpURLConnection? = null
        var result = ""
        try {
            urlConn = URL(url).openConnection() as HttpURLConnection
            if (urlConn != null) {
                val code = urlConn!!.responseCode
                if (code != 200) {
                    throw IOException("Invalid response from server: $code")
                }
                val rd = BufferedReader(InputStreamReader(urlConn!!.inputStream))
                var check: Boolean = true
                while (true) {
                    var line = rd.readLine()
                    if (line == null) {
                        break
                    } else {
                        if (check){
                            result += line
                            check = false
                        }
                        else {
                            result += "\n" +  line
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            urlConn?.disconnect()
        }
        return result
    }
}