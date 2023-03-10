package com.akotsenko.roomtest.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.akotsenko.roomtest.APP
import com.akotsenko.roomtest.R
import com.akotsenko.roomtest.databinding.FragmentAddNoteBinding
import com.akotsenko.roomtest.databinding.FragmentStartBinding
import com.akotsenko.roomtest.model.NoteModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val descriprion = binding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, description = descriprion)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }


    }

}