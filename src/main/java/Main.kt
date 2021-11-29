import objects.Position
import objects.entities.Player
import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.grid.TileGrid

fun main() {
    val player = Player(Position(0, 0))

    val config = AppConfig.newBuilder()
        .withSize(60, 30)
        .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
        .build()

    val tileGrid: TileGrid = SwingApplications.startTileGrid(config)

    tileGrid.draw(player.toTile(), player.toPosition())
}