package com.example.constraintloginapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.constraintloginapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

/* fun validatePassword(password: String): Boolean {
    val minLength = 8
    val maxLength = 20
    val regexPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"

    if (password.length < minLength || password.length > maxLength) {
        return false
    }

    val regex = Regex(regexPattern)
    return regex.matches(password)

}
In this code, we define the validatePassword function that takes a password as input and returns a Boolean indicating whether the password is valid or not.

The function checks the length of the password to ensure it is between 8 and 20 characters (inclusive). It then uses a regular expression pattern to enforce the following character set requirements:

At least one lowercase letter ((?=.*[a-z]))
At least one uppercase letter ((?=.*[A-Z]))
At least one digit ((?=.*\d))
At least one special character from @ $ ! % * ? & ((?=.*[@\$!%*?&]))
Only allows characters from the set [A-Za-z\d@$!%*?&]
The main function demonstrates the usage of validatePassword by passing different passwords and printing whether they are valid or not.

Note: You can modify the regular expression pattern or the minimum/maximum length requirements to fit your specific password validation needs.
*/