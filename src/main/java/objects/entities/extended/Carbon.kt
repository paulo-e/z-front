package objects.entities.extended

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import lombok.Setter
import objects.Position

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
open class Carbon(unicode: Char, position: Position) : Entity(unicode, position) {
    private var health: Int = 0
    private var energy: Int = 0

    open fun isDead(): Boolean {
        return health > 0
    }

    open fun isAlive(): Boolean {
        return !isDead()
    }

    open fun takeDamage(value: Int) {
        health -= value
    }

    open fun heal(value: Int) {
        health += value
    }

    open fun useEnergy(value: Int) {
        energy -= value
    }

    open fun healEnergy(value: Int) {
        energy += value
    }
}