English | [Türkçe](./README.tr-TR.md)


<div align="center">

<h1 align="center">Object Detection with OpenCV</h1>

<a href="https://github.com/mesutpiskin/computer-vision-guide">Image Processing and Computer Vision Documentation Project (EN, TR)</a>

<img src="https://opencv.org/assets/news/opencv_java_logo_small.png"/>

</div>

***

### Examples

There are three examples in the repository.

1. [Haar Cascade] - Object detection face and eye etc.
2. [Color Detection] - Object detection and tracking using object color.
3. [Template Matching] - Object detection with template matching.
4. [Deep Learning] - Object detection with deep neural network (DNN).



## Example 1: Face And Eye Detection


*Source code location: src/FaceAndEyeDetection/*

Object detection examples with haar cascade classifier algorithm (Face, eyes, mouth, other objects etc.). Cascade Classifier Training http://docs.opencv.org/3.1.0/dc/d88/tutorial_traincascade.html

**What is Haar cascade?**
Haar cascade classifier
Object Detection using Haar feature-based cascade classifiers is an effective object detection method proposed by Paul Viola and Michael Jones in their paper, "Rapid Object Detection using a Boosted Cascade of Simple Features" in 2001. It is a machine learning based approach where a cascade function is trained from a lot of positive and negative images. It is then used to detect objects in other images.

**Requirements**

- OpenCV 3.x Version
- Java > 6 Version

Face and eye detection by the camera using haar cascade algorithm.

**Video:**

<a href="https://youtu.be/cDUNpBmymXw">
<img width="500px" src="./res/template.png"/>
</a>

## Example 2: Object Detection and Tracking Using Color

*Source code location: src/ColorBasedObjectTracker/*

An example of an application where OpenCV is used to detect objects based on color differences.

**Requirements**

- OpenCV >2.x Version
- Java >6 Version

<img width="500px" src="./res/color_based.png"/>

## Example 3: Object Detection with Template Matching

*Source code location: src/TemplateMatchingObjectDetection/*

Template matching is a technique for finding areas of an image that match (are similar) to a template image (patch).

**Requirements**

- OpenCV 3.x Version
- Java >6 Version

My blog post for [template matching.](http://mesutpiskin.com/blog/opencv-template-matching-ile-nesne-tespiti.html)

<img width="500px" src="./res/template-matching-sonuc.jpg"/>



## Example 4: Object Detection with DNN

*Source code location: src/DeepNeuralNetwork/*

- OpenCV > 3.3 Version

In this tutorial you will learn how to use opencv dnn module for image classification by using MobileNetSSD_deploy trained network. My blog post for [deep neural network.](http://mesutpiskin.com/blog/opencv-derin-ogrenme-nesne-tanima.html)



<img width="400px" src="./res/dnn.png"/>
<img width="400px" src="./res/opencv_dnn.png"/>






[haar cascade]: #
[color detection]: #
[template matching]: #
[deep learning]: #