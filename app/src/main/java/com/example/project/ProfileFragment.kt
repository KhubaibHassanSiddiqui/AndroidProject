package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.profile) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile, container, false)

        val button: View = view.findViewById(R.id.orderLink)
        val button2:View =view.findViewById(R.id.orders)
        button.setOnClickListener {
            val intent = Intent(activity, MyOrdersActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(activity, MyOrdersActivity::class.java)
            startActivity(intent)
        }

        val message: View = view.findViewById(R.id.mymessages)
        message.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ChatFragment())
                .addToBackStack(null)
                .commit()
        }
        val banner: View = view.findViewById(R.id.bannerImage)
        banner.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, VoucherFragment())
                .addToBackStack(null)
                .commit()
        }

        val settings : View = view.findViewById(R.id.settingsIcon)
        settings.setOnClickListener {
            val intent = Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
