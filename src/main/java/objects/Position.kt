package objects

import lombok.AllArgsConstructor

@AllArgsConstructor
open class Position(var x: Int, var y: Int) {
    open fun addToX(value: Int) {
        this.x += value
    }

    open fun addToY(value: Int) {
        this.y += value
    }

    open fun add(toX: Int, toY: Int) {
        addToX(toX)
        addToY(toY)
    }

    open fun subToX(value: Int) {
        this.x -= value
    }

    open fun subToY(value: Int) {
        this.y -= value
    }

    open fun sub(toX: Int, toY: Int) {
        subToX(toX)
        subToY(toY)
    }
}