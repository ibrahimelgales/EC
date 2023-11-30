package com.easycashwallet.tasks.utils.extention

import org.koin.core.module.Module
import org.koin.dsl.module

fun lazyModule(builder: Module.() -> Unit): Lazy<Module> = lazy { module { builder.invoke(this) } }