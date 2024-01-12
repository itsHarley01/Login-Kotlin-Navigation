package com.sample.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
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
        val inflater = inflater.inflate(R.layout.fragment_login, container, false)
        val registerButton: Button = inflater.findViewById(R.id.register)
        val loginButton: Button = inflater.findViewById(R.id.login)
        var username: EditText = inflater.findViewById(R.id.username)
        var password: EditText = inflater.findViewById(R.id.pass)

        var usern = arguments?.getString("usernameKey")
        var passn = arguments?.getString("passwordKey")



        loginButton.setOnClickListener(){
            if(!username.text.toString().isEmpty() && !password.text.toString().isEmpty()){
                if(username.text.toString() == usern && password.text.toString() == passn){
                    val bundle = Bundle().apply {
                        putString("usernameKey", usern)
                        putString("passwordKey", passn)
                    }
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                    Toast.makeText(requireContext(),"Logged in",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(),"Please Enter Username or Password",Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString("usernameKey", usern)
                putString("passwordKey", passn)
            }
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment, bundle)
        }
        return inflater
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}