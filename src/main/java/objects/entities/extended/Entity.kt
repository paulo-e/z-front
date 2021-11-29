package objects.entities.extended

import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import org.hexworks.zircon.api.color.ANSITileColor
import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.data.Tile

@RequiredArgsConstructor
@NoArgsConstructor
open class Entity(private var unicode: String) {
    open fun getUnicode(): String {
        return this.unicode
    }

    open fun toTile(): Tile {
        return Tile.newBuilder()
            .withCharacter("@".toCharArray()[0])
            .withBackgroundColor(TileColor.transparent())
            .withForegroundColor(ANSITileColor.RED)
            .build()
    }
}