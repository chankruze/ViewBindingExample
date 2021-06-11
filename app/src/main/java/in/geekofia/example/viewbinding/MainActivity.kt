package `in`.geekofia.example.viewbinding

import `in`.geekofia.example.viewbinding.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // with view binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Call the static `inflate()` method included in the generated binding class.
        //    This creates an instance of the binding class for the activity to use.
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // 2. Get a reference to the root view by either calling the getRoot() method or using Kotlin property syntax.
        val view = binding.root
        // 3. Pass the root view to `setContentView()` to make it the active view on the screen.
        setContentView(view)

        /* reference to rollButton */
        binding.buttonRoll.setOnClickListener {
            binding.textViewResult.text = rollDice().toString()
        }
    }

    // without view binding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val textViewResult: TextView = findViewById(R.id.text_view_result)
//        val buttonRoll: Button = findViewById(R.id.button_roll)
//        buttonRoll.setOnClickListener {
//            textViewResult.text = rollDice().toString()
//        }
//    }

    private fun rollDice(): Int {
        return (1..6).random()
    }
}