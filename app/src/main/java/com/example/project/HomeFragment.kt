package com.example.project
import ProductAdapter
import com.google.firebase.database.*
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.project.models.Product
import com.google.firebase.auth.FirebaseAuth
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment(R.layout.homepage) {
    private lateinit var database: DatabaseReference
    private lateinit var products: MutableList<Product>
    private lateinit var adapter: ProductAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private var timer: Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
//        setUpClickListener(view.findViewById(R.id.productimg))
//        setUpClickListener(view.findViewById(R.id.productimg2))
//        setUpClickListener(view.findViewById(R.id.productimg3))
//        setUpClickListener(view.findViewById(R.id.productimg4))

        viewPager = view.findViewById(R.id.viewPager)

        val imageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
        )

        imageSliderAdapter = ImageSliderAdapter(imageList)
        viewPager.adapter = imageSliderAdapter

        val voucherButton = view.findViewById<TextView>(R.id.voucherLink)
        voucherButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, VoucherFragment())
                .addToBackStack(null)
                .commit()
        }

        val vouchers: View = view.findViewById(R.id.vouchers)
        vouchers.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, VoucherFragment())
                .addToBackStack(null)
                .commit()
        }

        val voucherimg: View = view.findViewById(R.id.voucherImage)
        voucherimg.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ActivitiesFragment())
                .addToBackStack(null)
                .commit()
        }
        database = FirebaseDatabase.getInstance().getReference("product/products")

        products = mutableListOf()

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (dataSnapshot in snapshot.children) {
                    val product = dataSnapshot.getValue(Product::class.java)
                    if (product != null) {
                        products.add(product)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
            }

        })

        setupRecyclerView(view)


        return view
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ProductAdapter(products)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        resetLogoutTimer() // Start the logout timer when the fragment is in the foreground
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel() // Cancel the timer when the fragment is no longer in the foreground
    }

    private fun resetLogoutTimer() {
        timer?.cancel() // Cancel the previous timer
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {
                    // Log the user out
                    FirebaseAuth.getInstance().signOut()
                    // Redirect to the LoginActivity
                    startActivity(Intent(activity, LoginActivity::class.java))
                    activity?.finish()
                }
            }
        }, 15 * 60 * 1000) // Set the timer to 15 minutes
    }

    private fun setUpClickListener(view: View) {
        view.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ProductFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}

