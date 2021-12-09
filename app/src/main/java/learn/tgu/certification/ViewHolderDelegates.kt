package learn.tgu.certification

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderDelegates(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textViewDelegateName: TextView =
        itemView.findViewById(R.id.text_view_delegatesTGU_name)

    fun bind(name: String) {
        textViewDelegateName.text = name
    }
}