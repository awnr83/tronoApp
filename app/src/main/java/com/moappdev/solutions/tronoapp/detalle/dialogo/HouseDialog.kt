package com.moappdev.solutions.tronoapp.detalle.dialogo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.moappdev.solutions.tronoapp.R
import com.moappdev.solutions.tronoapp.network.House
import kotlinx.android.synthetic.main.dialog_house.view.*

class HouseDialog:DialogFragment() {
   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val dialogView= LayoutInflater.from(context).inflate(R.layout.dialog_house,null,false)
       val arg= HouseDialogArgs.fromBundle(arguments!!).item

       with(arg){
           dialogView.setBackgroundResource(House.getMaterial(arg.name!!)[0])
           dialogView.tvName.text=arg.name
           dialogView.tvLema.text=arg.region
           dialogView.tvRegion.text=arg.region
       }

       return AlertDialog.Builder(context)
            .setView(dialogView)
            .setPositiveButton("Aceptar",{_,_ ->dismiss()})
            .create()
    }
}