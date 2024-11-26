package com.multiplatform.webview.web

import platform.WebKit.WKNavigationAction
import platform.WebKit.WKUIDelegateProtocol
import platform.WebKit.WKWebView
import platform.WebKit.WKWebViewConfiguration
import platform.WebKit.WKWindowFeatures
import platform.darwin.NSObject

class WKUIDelegate(
    private val state : WebViewState,
) : NSObject(), WKUIDelegateProtocol {
    override fun webView(
        webView: WKWebView,
        createWebViewWithConfiguration: WKWebViewConfiguration,
        forNavigationAction: WKNavigationAction,
        windowFeatures: WKWindowFeatures
    ): WKWebView? {
        val targetFrame = forNavigationAction.targetFrame
        if(targetFrame != null && targetFrame.isMainFrame()){
            return null
        }
        state.webView?.webView?.loadRequest(forNavigationAction.request)
        return null
    }
}
