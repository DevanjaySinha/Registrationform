package com.example.registrationform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentRegistration()
        }
    }
}

@Composable
fun StudentRegistration() {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }

    var java by remember { mutableStateOf(false) }
    var kotlin by remember { mutableStateOf(false) }

    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Student Registration Form",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Gender",
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = gender == "Male",
                onClick = { gender = "Male" }
            )
            Text("Male")

            Spacer(modifier = Modifier.width(10.dp))

            RadioButton(
                selected = gender == "Female",
                onClick = { gender = "Female" }
            )
            Text("Female")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Skills",
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = java,
                onCheckedChange = { java = it }
            )
            Text("Java")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it }
            )
            Text("Kotlin")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (name.isEmpty() || email.isEmpty()) {
                    result = "Please fill all mandatory fields!"
                } else {
                    val skills = buildString {
                        if (java) append("Java ")
                        if (kotlin) append("Kotlin")
                    }

                    result =
                        "Name: $name\nEmail: $email\nGender: $gender\nSkills: $skills"
                }
            }
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = result,
            fontSize = 16.sp
        )
    }
}