import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmpsharedresourcesexample.composeapp.generated.resources.Res
import kmpsharedresourcesexample.composeapp.generated.resources.button_image_switch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    
    var activeGalleryImage: GalleryImage by remember { mutableStateOf(GalleryImage.ANDROID) }
    
    MainContent(
     activeGalleryImage = activeGalleryImage,
        onSwitchImage = {
            activeGalleryImage = when(activeGalleryImage) {
                GalleryImage.ANDROID -> GalleryImage.APPLE
                GalleryImage.APPLE -> GalleryImage.ANDROID
            }
        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainContent(
    activeGalleryImage: GalleryImage,
    onSwitchImage: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            bitmap = imageResource(activeGalleryImage.imageRes),
            contentDescription = null
        )
        
        Text(
            text = stringResource(activeGalleryImage.descriptionRes)
        )
        
        Button(
            onClick = onSwitchImage
        ) {
            Text(text = stringResource(Res.string.button_image_switch))
        }
    }
}

@Preview
@Composable
private fun MainContentPreview() {
    MaterialTheme {
        MainContent(
            activeGalleryImage = GalleryImage.ANDROID,
            onSwitchImage = {}
        )
    }
}