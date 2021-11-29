package objects.entities.extended

import lombok.*
import classes.Position

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
open class Human(position: Position) : Carbon('@', position) {
    private var name: String = ""
}