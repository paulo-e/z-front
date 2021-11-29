package objects.enums

enum class Weapons {
    STICK {
        override var damage = 5
        override var title = "Stick"
    },
    SWORD {
        override var damage = 10
        override var title = "Sword"
    };

    abstract var damage: Int
    abstract var title: String
    fun doDamage(health: Int): Int {
        return health - this.damage
    }
}