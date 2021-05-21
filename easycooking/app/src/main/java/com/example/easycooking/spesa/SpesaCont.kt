package com.example.easycooking.spesa

import android.provider.BaseColumns
import kotlin.properties.Delegates


object SpesaCont {
    const val DB_NAME = "com.example.easycooking.spesa.db"
    const val DB_VERSION = 1

    object SpesaEntry : BaseColumns {
        var _ID by Delegates.notNull<Int>()
        const val TABLE = "lista"
        const val COL_TASK_TITLE = "prodottoCompra"
    }
}
