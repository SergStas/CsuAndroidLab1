package com.example.csuandroidlab1

import android.content.Context
import com.example.csuandroidlab1.App

val Context.factory get() = (applicationContext as App).appComponent.factory()