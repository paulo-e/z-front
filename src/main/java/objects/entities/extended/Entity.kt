package objects.entities.extended

import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import objects.classes.Color
import objects.classes.Position
import org.hexworks.zircon.api.color.ANSITileColor
import org.hexworks.zircon.api.data.Tile

@RequiredArgsConstructor
@NoArgsConstructor
open class Entity(private var char: Char, open val position: Position) {
    open val color: Color = Color(ANSITileColor.WHITE)

    open fun changePosition(position: Position) {
        this.position.x = position.x
        this.position.y = position.y
    }

    open fun toPosition(): org.hexworks.zircon.api.data.Position {
        return position.toPosition()
    }

    open fun toTile(): Tile {
        return Tile.newBuilder()
            .withForegroundColor(color.foreground)
            .withCharacter(this.char)
            .build()
    }
}