@file:OptIn(ExperimentalResourceApi::class)

import kmpsharedresourcesexample.composeapp.generated.resources.*
import kmpsharedresourcesexample.composeapp.generated.resources.Res
import kmpsharedresourcesexample.composeapp.generated.resources.android_kawaii
import kmpsharedresourcesexample.composeapp.generated.resources.apple_kawaii
import kmpsharedresourcesexample.composeapp.generated.resources.image_description_android
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource

enum class GalleryImage(
    val imageRes: DrawableResource,
    val descriptionRes: StringResource
) {
    
    ANDROID(
        imageRes = Res.drawable.android_kawaii,
        descriptionRes = Res.string.image_description_android
    ),
    APPLE(
        imageRes = Res.drawable.apple_kawaii,
        descriptionRes = Res.string.image_description_apple
    )
}
