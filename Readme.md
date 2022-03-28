# Design

Classes are divided into relevant packages; interfaces CanvasPainter (implemented by CanvasPainterImpl) and Painter (
implemented by Line & Rectangle) list the methods applied.

Enums are used to store and access static data such as input commands, as well as the painting parameters used.

Code can be run using the 'CanvasMain' class, and by inputting commands on the console. Relevant exceptions have been
thrown at suitable locations to help identify any issues.

As an improvement, additional functionality (e.g. painting a circle, enabling a diagonal line etc.) can be provided in
the console canvas project.

# Testing

Test cases are provided for functionality of different painting objects, such as Canvas, Line, Rectangle and Fill.

As an improvement, integration tests can be included in the code.