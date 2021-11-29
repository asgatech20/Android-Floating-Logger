/**
 * Copyright (C) 2016  Sandeep Fatangare <sandeep@fatangare.info>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.fatangare.logcatviewer.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.fatangare.logcatviewer.service.LogcatViewerFloatingView;

import com.fatangare.logcatviewer.standout.StandOutWindow;

/**
 * This class will launch {@link LogcatViewerFloatingView} view.
 */
public class LogcatViewer {
    /**
     * Launch {@link LogcatViewerFloatingView} view.
     *
     * @param context context.
     */
    public static void showLogcatLoggerView(AppCompatActivity context) {
        checkPermission(context);
    }

    /**
     * Ask for DrawOverLay permission if android is 6+
     */
    private static void checkPermission(AppCompatActivity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(context)) {
                int REQUEST_CODE = 101;
                Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                myIntent.setData(Uri.parse("package:" + context.getPackageName()));
                ((AppCompatActivity) context).startActivityForResult(myIntent, REQUEST_CODE);
            } else {
                popUpLogger(context);
            }
        } else {
            popUpLogger(context);
        }
    }

    private static void popUpLogger(Context context) {
        Log.e("loggerView", "popedUp");
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
        StandOutWindow
                .show(context, LogcatViewerFloatingView.class, StandOutWindow.DEFAULT_ID);
    }

    /**
     * Close  {@link LogcatViewerFloatingView} view.
     *
     * @param context context.
     */
    public static void closeLogcatLoggerView(Context context) {
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
    }
}
