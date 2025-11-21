package com.example.llmnote.`data`.local

import kotlin.reflect.KClass

internal fun KClass<AppDatabase>.instantiateImpl(): AppDatabase =
    com.example.llmnote.`data`.local.AppDatabase_Impl()
