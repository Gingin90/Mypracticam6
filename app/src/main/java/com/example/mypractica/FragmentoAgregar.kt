package com.example.mypractica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypractica.databinding.FragmentFragmentoAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentoAgregar.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentoAgregar : Fragment() {
   lateinit var binding : FragmentFragmentoAgregarBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragmentoAgregarBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment
        initListener()
        loadTasks()
        return binding.root
    }


        private fun initListener() {
            binding.btAgregar.setOnClickListener {
                val texto = binding.editTextTarea.text.toString()
                saveTask(texto)
            }
        }

    private fun saveTask(texto: String) {
    val dao =TareaBaseDato.getDatabase(requireContext()).getTaskDao()
        val task = Tarea(texto,"fecha")
        GlobalScope.launch { dao.insertarTarea(task) }
    }

    private  fun loadTasks(){
        val dao =TareaBaseDato.getDatabase(requireContext()).getTaskDao()
        GlobalScope.launch {
            val tasks = dao.getTasks()
            val tasksAsText = tasks.joinToString("\n") { it.nombreTarea }
            binding.textViewTar.text = tasksAsText
        }

    }


}
