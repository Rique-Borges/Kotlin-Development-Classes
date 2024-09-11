import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class QuestionDialog {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun QuestionTemplate(
        question: String,
        options: List<String>,
        correctAnswer: Int,
        onDismiss: () -> Unit,
        onAnswerSelected: (Boolean) -> Unit
    ) {
        var selectedOption by remember { mutableStateOf(-1) }

        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text("Questão") },
            text = {
                Column {
                    Text(question)
                    options.forEachIndexed { index, option ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            RadioButton(
                                selected = selectedOption == index,
                                onClick = { selectedOption = index }
                            )
                            Text(option)
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = {
                    val isCorrect = selectedOption == correctAnswer
                    onAnswerSelected(isCorrect)
                    onDismiss()
                }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text("Sair")
                }
            }
        )
    }
}
