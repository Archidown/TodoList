package com.example.todo_list.view.icons


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val TodayIcon: ImageVector
    get() {
        if (_TodayIcon != null) {
            return _TodayIcon!!
        }
        _TodayIcon =
            ImageVector.Builder(
                name = "today",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.Companion.NonZero,
                    ) {
                        moveTo(7.23f, 15.78f)
                        quadTo(6.5f, 15.05f, 6.5f, 14f)
                        reflectiveQuadTo(7.23f, 12.23f)
                        reflectiveQuadTo(9f, 11.5f)
                        reflectiveQuadToRelative(1.78f, 0.72f)
                        reflectiveQuadTo(11.5f, 14f)
                        reflectiveQuadToRelative(-0.72f, 1.78f)
                        reflectiveQuadTo(9f, 16.5f)
                        reflectiveQuadTo(7.23f, 15.78f)
                        close()
                        moveTo(5f, 22f)
                        quadTo(4.18f, 22f, 3.59f, 21.41f)
                        reflectiveQuadTo(3f, 20f)
                        verticalLineTo(6f)
                        quadTo(3f, 5.18f, 3.59f, 4.59f)
                        reflectiveQuadTo(5f, 4f)
                        horizontalLineTo(6f)
                        verticalLineTo(2f)
                        horizontalLineTo(8f)
                        verticalLineTo(4f)
                        horizontalLineToRelative(8f)
                        verticalLineTo(2f)
                        horizontalLineToRelative(2f)
                        verticalLineTo(4f)
                        horizontalLineToRelative(1f)
                        quadToRelative(0.83f, 0f, 1.41f, 0.59f)
                        quadTo(21f, 5.18f, 21f, 6f)
                        verticalLineTo(20f)
                        quadToRelative(0f, 0.82f, -0.59f, 1.41f)
                        reflectiveQuadTo(19f, 22f)
                        horizontalLineTo(5f)
                        close()
                        moveTo(5f, 20f)
                        horizontalLineTo(19f)
                        verticalLineTo(10f)
                        horizontalLineTo(5f)
                        verticalLineTo(20f)
                        close()
                        moveTo(5f, 8f)
                        horizontalLineTo(19f)
                        verticalLineTo(6f)
                        horizontalLineTo(5f)
                        verticalLineTo(8f)
                        close()
                        moveTo(5f, 8f)
                        verticalLineTo(6f)
                        verticalLineTo(8f)
                        close()
                    }
                }
                .build()
        return _TodayIcon!!
    }

private var _TodayIcon: ImageVector? = null