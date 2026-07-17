package me.capcom.smsgateway.modules.receiver

import me.capcom.smsgateway.modules.settings.KeyValueStorage
import me.capcom.smsgateway.modules.settings.get

class ReceiverSettings(
    private val storage: KeyValueStorage,
) {
    // Fork default OFF: our cold-SMS gateway captures inbound SMS via the
    // broadcast receiver only. Enabling the content-provider observer too
    // would double-capture -> duplicate inbound webhooks to the bridge.
    var contentProviderEnabled: Boolean
        get() = storage.get<Boolean>(CONTENT_PROVIDER_ENABLED) ?: false
        set(value) = storage.set(CONTENT_PROVIDER_ENABLED, value)

    companion object {
        private const val CONTENT_PROVIDER_ENABLED = "content_provider_enabled"
    }
}
