package giavu.co.jp.spintplaning.extension

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-11
 */
interface Accessor<out T> {
    fun get(): T
}

fun <T> accessorOf(value: T) = object : Accessor<T> {
    override fun get(): T {
        return value
    }
}