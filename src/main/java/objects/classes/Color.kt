package objects.classes

import org.hexworks.zircon.api.color.ANSITileColor

class Color(var foreground: ANSITileColor) {
    var background: ANSITileColor = ANSITileColor.BLACK
}