import org.hexworks.zircon.api.CP437TilesetResources
import org.hexworks.zircon.api.SwingApplications
import org.hexworks.zircon.api.application.AppConfig
import org.hexworks.zircon.api.grid.TileGrid
import views.StartView

fun main() {
    val config = AppConfig.newBuilder()
        .withSize(60, 30)
        .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
        .withDebugMode(false)
        .withTitle("Z Game")
        .build()

    val grid: TileGrid = SwingApplications.startTileGrid(config)

    StartView(grid).dock()
}