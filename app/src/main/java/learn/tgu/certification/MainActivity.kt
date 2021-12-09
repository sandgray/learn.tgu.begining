package learn.tgu.certification

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val KEY_LAST_SELECTED_ITEM = "last_selected_item"
private val KEY_FRAGMENT_DICE_ROLL = FragmentDiceRoll().javaClass.name
private val KEY_FRAGMENT_DELEGATES = FragmentTGU().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var buttonNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNavigationView = findViewById(R.id.bottom_navigation)
        buttonNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.menu_bottom_item_dice_roll -> {
                    fragment =
                    /*
                        if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        KEY_FRAGMENT_DICE_ROLL
                    ) else
                     */
                     FragmentDiceRoll()
                }
                R.id.menu_bottom_item_delegates -> {
                    fragment =
                        /*
                        if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        KEY_FRAGMENT_DELEGATES
                    ) else
                        */
                        FragmentTGU()
                }
            }
            switchFragment(fragment!!)
            true
        }

        buttonNavigationView.selectedItemId =
            savedInstanceState?.getInt(KEY_LAST_SELECTED_ITEM) ?: R.id.menu_bottom_item_dice_roll
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(KEY_LAST_SELECTED_ITEM, buttonNavigationView.selectedItemId)

        /*
        // вся конструкция вызывает вылет при смене фоагментов =(
        val currentFragment: Fragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState, currentFragment.javaClass.name, currentFragment
        )
         */
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view_tag, fragment)
            .commit()
    }
}