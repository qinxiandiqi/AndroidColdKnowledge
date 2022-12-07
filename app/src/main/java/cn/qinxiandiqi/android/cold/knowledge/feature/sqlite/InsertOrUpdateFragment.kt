package cn.qinxiandiqi.android.cold.knowledge.feature.sqlite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.qinxiandiqi.android.cold.knowledge.R
import cn.qinxiandiqi.android.cold.knowledge.databinding.FeatureSqliteFragmentInsertOrUpdateBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class InsertOrUpdateFragment : Fragment() {

    private var _binding: FeatureSqliteFragmentInsertOrUpdateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FeatureSqliteFragmentInsertOrUpdateBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_InsertOrUpdateFragment_to_RouterFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}