package cn.qinxiandiqi.android.cold.knowledge.feature.sqlite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import cn.qinxiandiqi.android.cold.knowledge.R
import cn.qinxiandiqi.android.cold.knowledge.databinding.FeatureSqliteFragmentInsertOrUpdateBinding

/**
 * SQLite插入或更新部分字段
 *
 * created by Jianan on 2022/12/7.
 */
class InsertOrUpdateFragment : Fragment() {

    private var _binding: FeatureSqliteFragmentInsertOrUpdateBinding? = null
    private val viewModel by viewModels<InsertOrUpdateViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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