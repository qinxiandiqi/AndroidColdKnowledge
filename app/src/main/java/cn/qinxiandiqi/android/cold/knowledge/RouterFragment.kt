package cn.qinxiandiqi.android.cold.knowledge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cn.qinxiandiqi.android.cold.knowledge.databinding.FragmentRouterBinding
import cn.qinxiandiqi.android.cold.knowledge.databinding.ItemRouterBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RouterFragment : Fragment() {

    private var _binding: FragmentRouterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val routeItems = listOf(
        RouterItem(
            R.string.fragment_sqlite_insert_or_update_label,
            R.id.action_RouterFragment_to_SecondFragment
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRouterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvRouter.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        binding.rvRouter.addItemDecoration(
            DividerItemDecoration(
                view.context,
                LinearLayoutManager.VERTICAL
            )
        )
        val adapter = RouterAdapter(findNavController(), routeItems)
        binding.rvRouter.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private data class RouterItem(
        @StringRes
        val name: Int,
        @IdRes
        val action: Int
    )

    private class RouterAdapter(
        private val navController: NavController,
        private val routerItems: List<RouterItem>
    ) :
        Adapter<RouterHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouterHolder {
            val itemBinding =
                ItemRouterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RouterHolder(navController, itemBinding)
        }

        override fun onBindViewHolder(holder: RouterHolder, position: Int) {
            val item = routerItems.getOrNull(position)
            if (item != null) {
                holder.bind(item)
            }
        }

        override fun getItemCount(): Int = routerItems.size
    }

    private class RouterHolder(
        private val navController: NavController,
        private val itemBinding: ItemRouterBinding
    ) :
        ViewHolder(itemBinding.root) {

        private var curRouterItem: RouterItem? = null

        init {
            itemBinding.root.setOnClickListener {
                curRouterItem?.let { navController.navigate(it.action) }
            }
        }


        fun bind(routerItem: RouterItem) {
            curRouterItem = routerItem
            itemBinding.tvRouterName.setText(routerItem.name)
        }
    }
}