package presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuOpen
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewHeadline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class MaterialComponent(
    val name: String,
    val icon: ImageVector
)

val materialComponents = listOf(
    MaterialComponent("Button", Icons.Default.TouchApp),
    MaterialComponent("TextField", Icons.Default.TextFields),
    MaterialComponent("Checkbox", Icons.Default.CheckBox),
    MaterialComponent("Switch", Icons.Default.ToggleOn),
    MaterialComponent("Slider", Icons.Default.Tune),
    MaterialComponent("Card", Icons.Default.CreditCard),
    MaterialComponent("Dialog", Icons.Default.ChatBubble),
    MaterialComponent("DropdownMenu", Icons.Default.ArrowDropDown),
    MaterialComponent("TopAppBar", Icons.Default.ViewHeadline),
    MaterialComponent("BottomAppBar", Icons.Default.Menu),
    MaterialComponent("FAB", Icons.Default.Add),
    MaterialComponent("NavigationDrawer", Icons.Default.MenuOpen)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialComponentGrid(onButtonClick: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Components") }) }
    ){ padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(materialComponents.size) { index ->
                val component = materialComponents[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (component.name == "Button") onButtonClick()
                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = component.icon,
                            contentDescription = component.name,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(component.name, maxLines = 1, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}