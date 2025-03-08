package com.example.layoutmobile4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutmobile4.ui.theme.LayoutMobile4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Ícone do app (Reduzido)
        Image(
            painter = painterResource(id = R.drawable.chat),
            contentDescription = "App Logo",
            modifier = Modifier.size(60.dp) // Ajuste no tamanho
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Título
        Text(
            text = "Chatt",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF009688)
        )

        // Subtítulo
        Text(
            text = "Simple mobile chat and notes.",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botões de login social
        SocialLoginButton("Sign in with Facebook", Color(0xFF3b5998))
        Spacer(modifier = Modifier.height(8.dp))
        SocialLoginButton("Sign in with Twitter", Color(0xFF00acee))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "or", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de entrada (Ícones Reduzidos)
        CustomTextField("Email", R.drawable.email, false)
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField("Password", R.drawable.cadeado, true)

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de Registro
        Button(
            onClick = { /* Ação ao clicar */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text(text = "Register", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Link para Login
        TextButton(onClick = { /* Navegar para Login */ }) {
            Text(text = "Log in", fontSize = 16.sp, color = Color(0xFF009688))
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Esqueci a senha
        Text(text = "I've forgotten my password?", color = Color.Gray, fontSize = 14.sp)
    }
}

// Componente de botão de login social
@Composable
fun SocialLoginButton(text: String, backgroundColor: Color) {
    Button(
        onClick = { /* Ação ao clicar */ },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.White)
    }
}

// Componente de campo de entrada (Ícones Reduzidos)
@Composable
fun CustomTextField(placeholder: String, iconId: Int, isPassword: Boolean) {
    OutlinedTextField(
        value = "",
        onValueChange = { /* Atualizar estado */ },
        placeholder = { Text(text = placeholder) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "Icon",
                tint = Color.Gray,
                modifier = Modifier.size(18.dp) // Ajuste no tamanho do ícone
            )
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
