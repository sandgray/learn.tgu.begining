package learn.tgu.certification

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentTGU : Fragment() {

    lateinit var recyclerViewDelegatesTGU: RecyclerView
    lateinit var buttonGoToSite: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_t_g_u, container, false)
        val listDelegatesName: Array<String> = resources.getStringArray(R.array.arrayDelegatesName)

        recyclerViewDelegatesTGU = view.findViewById(R.id.recycler_view_delegates_TGU)
        recyclerViewDelegatesTGU.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewDelegatesTGU.adapter = AdapterDelegatesTGU(listDelegatesName)

        buttonGoToSite=view.findViewById(R.id.button_go_to_site)
        buttonGoToSite.setOnClickListener {
            val link = Uri.parse("https://odin.study/ru/Dashboard")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }

        return view
    }


}