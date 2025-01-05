package com.example.project
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class MessagesFragment : Fragment(R.layout.messages) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.messages, container, false)

        val message: View = view.findViewById(R.id.chats_tab)
        message.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ChatFragment())
                .addToBackStack(null)
                .commit()
        }

        val order:View=view.findViewById(R.id.orders_tab)
        order.setOnClickListener {
            if (checkAuthentication(requireContext())) {
                val intent = Intent(activity, MyOrdersActivity::class.java)
                startActivity(intent)
            }
        }

        val act: View = view.findViewById(R.id.activities_tab)
        act.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }
        val promo: View = view.findViewById(R.id.promos_tab)
        promo.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }

        val promo1: View = view.findViewById(R.id.promo1)
        promo1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }
        val promo2: View = view.findViewById(R.id.promo2)
        promo1.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    private fun checkAuthentication(context: Context): Boolean {
        val user = FirebaseAuth.getInstance().currentUser
        return if (user != null) {
            true
        } else {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
            false
        }
    }
}
