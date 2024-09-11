package com.example.shoppinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp() {
    // Iniciando as variáveis
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        //Botão de Adicionar item
        Button(
            //Toda vez que ele é clickado, aparece um alert onde é possível adicionar as informações
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Adicionar Item")
        }
        //Coluna scrollável que vai conter os itens adicionados
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) { item ->
                //Checando se o item está sendo editado
                if (item.isEditing) {
                    ShoppingItemEditor(
                        item = item,
                        onEditComplete = { editedName, editedQuantity ->
                            // Esta linha encontra o item que está sendo editado e deixa o isEditing falso
                            sItems = sItems.map { it.copy(isEditing = false) }
                            // Esta linha "procura" o item que está sendo editado checando os IDs
                            val editedItem = sItems.find { it.id == item.id }
                            // Esta linha substitui o nome e a quantidade original pela editada
                            editedItem?.let {
                                it.name = editedName
                                it.quantity = editedQuantity
                            }
                        }
                    )
                } else {
                    ShoppingListItem(
                        item = item,
                        // Se o item for editado, esse codigo encontra o item que está sendo editado e substitui os dados
                        onEditClick = { sItems = sItems.map { it.copy(isEditing = it.id == item.id) } },
                        // se o item for deletado, ele vai na lista sItems e deleta o item da lista
                        onDeleteClick = { sItems = sItems - item }
                    )
                }
            }
        }
    }
    //Caixa de diálogo para adicionar um item
    if (showDialog) {
        itemQuantity = "1"
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Adicionar Item à Lista") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = {
                            itemQuantity = it

                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Este botão pega os dados do OutlinedTextField e cria um objeto ShoppingItem com os dados do item
                    Button(
                        onClick = {
                            if (itemName.isNotBlank()) {
                                val newItem = ShoppingItem(
                                    id = sItems.size + 1,
                                    name = itemName,
                                    quantity = itemQuantity.toInt()
                                )
                                sItems = sItems + newItem
                                showDialog = false
                                itemName = ""
                            }
                        }
                    ) {
                        Text("Adicionar")
                    }
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text("Cancelar")
                    }
                }
            }
        )
    }
}

// Este composable pega os dados adquiridos no alerta e adiciona eles na tela
@Composable
fun ShoppingListItem(item: ShoppingItem,
                     onEditClick: () -> Unit,
                     onDeleteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0XFF018786)),
                shape = RoundedCornerShape(20)
            ),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "Qtd: ${item.quantity}", modifier = Modifier.padding(8.dp))
        Row(  modifier = Modifier
            .padding(8.dp)) {
            IconButton(
                onClick = onEditClick,
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar Item")
            }
            IconButton(
                onClick = onDeleteClick,
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir Item")
            }
        }
    }
}

// Este composable representa a UI quando a variavel isEditing é verdadeira
@Composable
fun ShoppingItemEditor(item: ShoppingItem,onEditComplete: (String, Int) -> Unit) {
    // iniciando as variáveis
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = { editedName = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )

            BasicTextField(
                value = editedQuantity,
                onValueChange = { editedQuantity = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        Button(
            onClick = {
                isEditing = false
                onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1)
            }
        ) {
            Text("Salvar")
        }
    }
}