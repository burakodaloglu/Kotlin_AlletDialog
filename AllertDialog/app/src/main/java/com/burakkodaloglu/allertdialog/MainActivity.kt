package com.burakkodaloglu.allertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.burakkodaloglu.allertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var giriseposta = ""
        var girissifre= ""

        binding.txtuyeol.setOnClickListener{
            //AlertDialog Oluşturma
            val activity_uyeol = LayoutInflater.from(this).inflate(R.layout.activity_uyeol,null)
            val alertDialog= AlertDialog.Builder(this)
            alertDialog.setView(activity_uyeol)
            alertDialog.setNegativeButton("Kapat"){dialog, which ->}
            alertDialog.show()

            val btnkaydet = activity_uyeol.findViewById<TextView>(R.id.btnkaydet)
            btnkaydet.setOnClickListener {
                val etuyeposta=activity_uyeol.findViewById<TextView>(R.id.etuyeposta).text.toString().trim()
                val etuyesifre=activity_uyeol.findViewById<TextView>(R.id.etuyesifre).text.toString().trim()
                giriseposta = etuyeposta
                girissifre= etuyesifre
                Toast.makeText(applicationContext,"Başarılı",Toast.LENGTH_LONG).show()
            }
        }
        //Giriş Yapma
        binding.btngiris.setOnClickListener{
            val etposta = binding.etposta.text.toString().trim()
            val etsifre = binding.etsifre.text.toString().trim()
            if (TextUtils.isEmpty(etposta)){
                binding.etposta.error="Lütfen e-posta adresinizi giriniz"
            }
            if (TextUtils.isEmpty(etsifre)){
                binding.etsifre.error="Lütfen şifrenizi giriniz"
            }else{
                if ((giriseposta==etposta)&& (girissifre==etsifre))
                {
                    //AlertDialog Oluşturma
                    val alertDialog= AlertDialog.Builder(this)
                    alertDialog.setTitle("Başarılı")
                    alertDialog.setMessage("Giriş işleminiz başarılı bir şekilde gerçekleşmiştir.")
                    alertDialog.setNegativeButton("Kapat"){dialog, which ->}
                    alertDialog.show()
                }
                else{
                    //AlertDialog Oluşturma
                    val alertDialog= AlertDialog.Builder(this)
                    alertDialog.setTitle("Hatalı")
                    alertDialog.setMessage("Giriş işleminiz hatalı.")
                    alertDialog.setNegativeButton("Kapat"){dialog, which ->}
                    alertDialog.show()
                }
            }
        }
    }
}
















