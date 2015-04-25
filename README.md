# Draw

Draw is an easy-to-use graphics library for beginning programmers. It provides convenient ways to use Java's graphics tools without going through the hassle of using Swing. Draw removes the mess that is creating a new graphics program in Java and instead simplifies the process down to one line of code.

### Version
1.0.1

### Description

Draw provides a layer on top of Java's graphics library to create a simple way to jump into programming wihtout having to know the in depth nuances of objects, inheritence, polymorphism, etc. All users must do is include the Draw.java file in their project folder, and they are ready to go! 

The Draw API allows users to draw various figures on a JFrame. The figures supported are as follows:

* Lines
* Rectangles
* Ovals
* Images
* Text

Draw also allows users to create new windows, change the color of subsequent figures, grab the coordinates of the mouse, and know whenever it is pressed.

#####Colors

Draw supports different colors for figures: Red, Orange, Yellow, Green, Blue, Cyan, MAgenta, Pink, White, Black, and Gray

Draw does not conform to Java's confusing coordinate system; instead of the point (0, 0) being at the top left, it is in the bottom left. Furthermore, figures are drawn by reference to the bootom left corner.

### Usage

To draw a line that goes from (5, 5) to (25, 25), type the following:

```
Draw.line(5, 5, 25, 25);
```

A rectangle whose bottom left corner is at (10, 10), has a width of 15 and a length of 25 would go like this:

```
Draw.rect(10, 10, 15, 25);
```

An image whose bottom left corner is at (20, 25) with dimensions 15 X 30 would look like this:

```
Draw.image("image.jpg", 20, 25, 15, 30);
```

For complete instruction, look at the Javadoc included in the API.

To get started with Draw, download the package and drag the Draw.java file into your project directory. That's all there is to it!


**Made for ATCS in 2015**