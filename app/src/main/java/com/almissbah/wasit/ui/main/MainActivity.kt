package com.almissbah.wasit.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.View
import com.almissbah.wasit.R
import com.almissbah.wasit.data.local.db.entity.CategoryEntity
import com.almissbah.wasit.data.repo.AppRepo
import com.almissbah.wasit.ui.detail.DetailsActivity
import com.almissbah.wasit.ui.detail.DetailsActivity.*
import com.almissbah.wasit.ui.main.adapter.CategoryAdapter
import com.almissbah.wasit.ui.main.adapter.OffersAdapter
import com.almissbah.wasit.ui.main.fragment.OffersFragment
import com.almissbah.wasit.ui.main.fragment.LikedOffersFragment
import com.almissbah.wasit.ui.main.fragment.ProfileFragment
import com.almissbah.wasit.ui.main.viewmodel.CategoryViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var categoryChangeListener: CategoryChangeListener
    private lateinit var mainBinding: com.almissbah.wasit.databinding.ActivityMainBinding
    private val likedOffersFragment: LikedOffersFragment = LikedOffersFragment()
    private val offersFragment: OffersFragment = OffersFragment()
    private val profileFragment: ProfileFragment = ProfileFragment()

    private lateinit var rvCategories: RecyclerView

    @Inject
    lateinit var repository: AppRepo
    private lateinit var mViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        initViewModel()
        initOffersFragment()
        setBottomNavListener()

    }

    private fun initView() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = mainBinding.drawerLayout
        val navView: NavigationView = mainBinding.navView

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        rvCategories = mainBinding.root.findViewById(R.id.rv_categories)
    }

    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get<CategoryViewModel>(CategoryViewModel::class.java)
        mViewModel.setRepository(repository)
        mViewModel.allCategories.observe(this, Observer { t ->
            var adapter = CategoryAdapter(t)
            rvCategories.adapter = adapter
            rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            adapter.setClickListener { view: View, categoryEntity: CategoryEntity ->
                Log.d(
                    OffersAdapter::class.java.simpleName,
                    "Activity CategoryEntity with title " + categoryEntity.title + " Clicked "
                )
                runOnUiThread { adapter.notifyDataSetChanged() }
                if (categoryChangeListener != null)
                    categoryChangeListener.onCategoryChange(categoryEntity)
            }
        })
    }

    private fun initOffersFragment() {

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, offersFragment)
        transaction.commit()

        offersFragment.setListener { offerEntity ->
            var intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(EXT_DATA, FRAG_OFFER_DETAIL_INDEX)
            intent.putExtra(OBJECT_ID, offerEntity.id)
            startActivity(intent)
        }
    }

    private fun setBottomNavListener() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_bar)
        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_layout, offersFragment)
                    transaction.commit()
                    rvCategories.visibility = View.VISIBLE
                }
                R.id.liked -> {
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_layout, likedOffersFragment)
                    transaction.commit()
                    rvCategories.visibility = View.GONE
                }
                R.id.profile -> {
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame_layout, profileFragment)
                    transaction.commit()
                    rvCategories.visibility = View.GONE
                }
            }
            true
        }
    }
    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_about_us -> {

            }

            R.id.nav_settings -> {

            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    interface CategoryChangeListener {
        fun onCategoryChange(category: CategoryEntity)
    }
}
