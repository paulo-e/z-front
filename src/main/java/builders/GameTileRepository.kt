package builders

import org.hexworks.zircon.api.color.TileColor
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.graphics.Symbols

object GameTileRepository {
    val EMPTY = Tile.empty()

    val FLOOR = Tile.newBuilder()
        .withCharacter(Symbols.INTERPUNCT)
        .withForegroundColor(TileColor.defaultForegroundColor())
        .withBackgroundColor(TileColor.transparent())
        .buildCharacterTile()

    val WALL = Tile.newBuilder()
        .withCharacter('#')
        .withForegroundColor(TileColor.defaultForegroundColor())
        .withBackgroundColor(TileColor.transparent())
        .buildCharacterTile()
}