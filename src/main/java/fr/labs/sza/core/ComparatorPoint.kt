package fr.labs.sza.core

class ComparatorPoint {

    companion object : Comparator<Point> {
        override fun compare(point1: Point, point2: Point): Int =
            point2.points - point1.points
    }
}