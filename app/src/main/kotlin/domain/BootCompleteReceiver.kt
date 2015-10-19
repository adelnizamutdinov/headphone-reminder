package domain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootCompleteReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context, intent: Intent) {
    setIfNeeded(context)
  }
}