import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState


@Composable
fun OfferTest() {
    val webViewState = rememberWebViewState("https://slotcity.ua")
    val navigator = rememberWebViewNavigator()
    webViewState.webSettings.backgroundColor = Color.White
    webViewState.webSettings.isJavaScriptEnabled = true
    webViewState.webSettings.allowFileAccessFromFileURLs = true
    webViewState.webSettings.androidWebSettings.allowFileAccess = true
    webViewState.webSettings.iOSWebSettings.bounces = false
    webViewState.webSettings.androidWebSettings.safeBrowsingEnabled = false
    webViewState.webSettings.zoomLevel = 1.0
    webViewState.webSettings.supportZoom = false
    webViewState.webSettings.androidWebSettings.domStorageEnabled = true
    webViewState.webSettings.customUserAgentString =
        webViewState.webSettings.customUserAgentString
            ?.replaceAfter(")", "")
    // TODO : Be sure to change this if changing info.plist

    WebView(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        state = webViewState,
        navigator = navigator,
    )
}
