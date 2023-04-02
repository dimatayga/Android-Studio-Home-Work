package com.example.skillbox_hw_quiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.databinding.FragmentQuizBinding
import com.example.skillbox_hw_quiz.quiz.QuizStorage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!


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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
        // return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonPush.setOnClickListener {
            val list = mutableListOf<Int>()
            when (binding.firstGroup.checkedRadioButtonId) {
                R.id.firstGroupOne -> list.add(0)
                R.id.firstGroupTwo -> list.add(1)
                R.id.firstGroupThree -> list.add(2)
                R.id.firstGroupFour -> list.add(3)
            }
            when (binding.secondGroup.checkedRadioButtonId) {
                R.id.secondGroupOne -> list.add(0)
                R.id.secondGroupTwo -> list.add(1)
                R.id.secondGroupThree -> list.add(2)
                R.id.secondGroupFour -> list.add(3)
            }
            when (binding.thirdGroup.checkedRadioButtonId) {
                R.id.thirdGroupOne -> list.add(0)
                R.id.thirdGroupTwo -> list.add(1)
                R.id.thirdGroupThree -> list.add(2)
                R.id.thirdGroupFour -> list.add(3)
            }
            val questionList = QuizStorage.answer(QuizStorage.getQuiz(QuizStorage.Locale.Ru), list)
            val bundle = Bundle().apply {
                putString("MyArg", questionList)
            }
            findNavController().navigate(R.id.resultFragment, bundle)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.startFragment)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}