package objects

import org.hexworks.zircon.api.data.Position as API

open class Position(var x: Int, var y: Int) {
    open fun addToX(value: Int) {
        x += value
    }

    open fun addToY(value: Int) {
        y += value
    }

    open fun add(toX: Int, toY: Int) {
        addToX(toX)
        addToY(toY)
    }

    open fun subToX(value: Int) {
        x -= value
    }

    open fun subToY(value: Int) {
        y -= value
    }

    open fun sub(toX: Int, toY: Int) {
        subToX(toX)
        subToY(toY)
    }

    open fun toPosition(): API {
        return API.create(x, y)
    }
}