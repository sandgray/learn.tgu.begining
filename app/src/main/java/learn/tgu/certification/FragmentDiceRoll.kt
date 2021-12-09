package learn.tgu.certification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val KEY_LAST_DICE_VALUE = "key_last_dice_value"

class FragmentDiceRoll : Fragment() {

    lateinit var imageViewDice: ImageView
    lateinit var buttonViewRoll: Button
    private val listImageDice: List<Int> = listOf(
        R.drawable.dice_one,
        R.drawable.dice_two,
        R.drawable.dice_three,
        R.drawable.dice_four,
        R.drawable.dice_five,
        R.drawable.dice_six
    )

    var lastDiceRollValue = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dice_roll, container, false)

        imageViewDice = view.findViewById(R.id.image_view_dice)
        buttonViewRoll = view.findViewById(R.id.button_view_roll_dice)

        if (savedInstanceState != null)
            imageViewDice.setImageResource(savedInstanceState.getInt(KEY_LAST_DICE_VALUE))

        buttonViewRoll.setOnClickListener {
            lastDiceRollValue = listImageDice.random()
            imageViewDice.setImageResource(lastDiceRollValue)
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_LAST_DICE_VALUE, lastDiceRollValue)
    }
}