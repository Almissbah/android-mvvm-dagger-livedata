package com.almissbah.wasit.ui.main

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
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.almissbah.wasit.R
import com.almissbah.wasit.data.local.db.entity.OfferEntity
import com.almissbah.wasit.data.repo.AppRepo
import com.almissbah.wasit.ui.base.BaseActivity
import com.almissbah.wasit.ui.detail.DetailsActivity
import com.almissbah.wasit.ui.detail.DetailsActivity.*
import com.almissbah.wasit.ui.main.fragment.OffersFragment
import com.almissbah.wasit.ui.main.fragment.LikedOffersFragment
import com.almissbah.wasit.ui.main.fragment.ProfileFragment
import com.almissbah.wasit.ui.main.viewmodel.CategoryViewModel
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var mainBinding: com.almissbah.wasit.databinding.ActivityMainBinding
    private val likedOffersFragment: LikedOffersFragment = LikedOffersFragment()
    private val offersFragment: OffersFragment = OffersFragment()
    private val profileFragment: ProfileFragment = ProfileFragment()


    @Inject
    lateinit var repository: AppRepo
    private lateinit var mViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        initToolbarAndNavDrawer()
        initViewModel()
        initOffersFragment()
        setBottomNavListener()
    }

    private fun initToolbarAndNavDrawer() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = mainBinding.drawerLayout
        val navView: NavigationView = mainBinding.navView
        supportActionBar?.elevation = 0F
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }


    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get<CategoryViewModel>(CategoryViewModel::class.java)
        mViewModel.setRepository(repository)

    }

    private fun initOffersFragment() {
        showFragment(offersFragment)
        offersFragment.setListener { offerEntity ->
            startDetailsActivity(offerEntity)
        }
    }


    private fun startDetailsActivity(offerEntity: OfferEntity) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(EXT_DATA, FRAG_OFFER_DETAIL_INDEX)
        intent.putExtra(OBJECT_ID, offerEntity.id)
        startActivity(intent)
    }
    private fun setBottomNavListener() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav_bar)
        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    showFragment(offersFragment)
                }
                R.id.liked -> {
                    showFragment(likedOffersFragment)
                }
                R.id.profile -> {
                    showFragment(profileFragment)
                }
            }
            true
        }
    }

    fun showFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
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

}
