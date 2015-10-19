package domain

import adeln.boilerplate.CheckerService
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import common.context.alarms
import common.intent.intent
import java.util.concurrent.TimeUnit

fun checkerService(c: Context): Intent =
    intent<CheckerService>(c)

fun setIfNeeded(c: Context): Unit =
    if (!alarmIsSet(c)) {
      val fifteen = TimeUnit.MINUTES.toMillis(15)
      c.alarms().setInexactRepeating(
          AlarmManager.ELAPSED_REALTIME,
          SystemClock.elapsedRealtime() + fifteen,
          fifteen,
          PendingIntent.getService(c, 0, checkerService(c), 0))
    }

fun alarmIsSet(c: Context): Boolean =
    PendingIntent.getService(c, 0, checkerService(c), PendingIntent.FLAG_NO_CREATE) != null
