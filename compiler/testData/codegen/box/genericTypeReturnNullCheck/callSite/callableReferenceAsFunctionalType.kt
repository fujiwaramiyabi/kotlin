// !LANGUAGE: +GenerateNullChecksForGenericTypeReturningFunctions
// TARGET_BACKEND: JVM
// WITH_RUNTIME

fun <T> bar(): () -> T {
    fun foo() = null as T
    return ::foo
}

fun box(): String {
    try {
        val x = bar<String>()
        x()
    } catch (e: KotlinNullPointerException) {
        return "OK"
    }
    return "Fail: KotlinNullPointerException should have been thrown"
}
