package io.github.evilsloth.goplusnotify.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.evilsloth.goplusnotify.R
import io.github.evilsloth.goplusnotify.notifications.GoPlusNotification
import io.github.evilsloth.goplusnotify.notifications.GoPlusNotifications
import io.github.evilsloth.goplusnotify.settings.ui.theme.GoPlusNotifyTheme

class SettingsActivity : ComponentActivity() {

    private lateinit var settingsRepository: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        settingsRepository = SettingsRepository(applicationContext)

        setContent {
            GoPlusNotifyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Settings(settingsRepository)
                }
            }
        }
    }
}

@Composable
fun Settings(settingsRepository: SettingsRepository) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.active_notifications),
            style = MaterialTheme.typography.overline,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp)
        )

        NotificationEnabledSwitch(settingsRepository, GoPlusNotifications.disconnectNotification)
        GoPlusNotifications.actionNotifications.forEach {
            NotificationEnabledSwitch(settingsRepository, it)
        }
    }
}

@Composable
fun NotificationEnabledSwitch(settingsRepository: SettingsRepository, notification: GoPlusNotification) {
    var enabled by remember { mutableStateOf(notification.isEnabled(settingsRepository)) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp, 0.dp)
    ) {
        Text(stringResource(notification.text))
        Switch(
            checked = enabled,
            onCheckedChange = {
                enabled = it
                notification.setEnabled(settingsRepository, it)
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GoPlusNotifyTheme {
        Settings(SettingsRepository(LocalContext.current))
    }
}