package learn.tgu.certification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegatesTGU(private val namesDelegates: Array<String>) :
    RecyclerView.Adapter<ViewHolderDelegates>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDelegates {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_delegates, parent, false)
        return ViewHolderDelegates(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderDelegates, position: Int) {
        val name = namesDelegates[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return namesDelegates.size
    }
}