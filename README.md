
![OpenCV](https://img.shields.io/badge/Library-OpenCV-Green.svg)
![jAVA](https://img.shields.io/badge/Language-Java-red.svg)

# Object Detection with OpenCV

[Youtube videos (Turkish)](https://www.youtube.com/watch?v=MhZtXgXtzNs&index=14&list=PLt-aCjPZOlWnAaWRVdH7X-L5eRfqHanW3)

[Blog post (Turkish)](http://mesutpiskin.com/blog/opencv-egitim-serisi)

### Examples
There are three examples in the repository.

* [Haar Cascade] -  Object detection face and eye etc.
* [Color Detection] - Object detection and tracking using object color.
* [Template Matching] - Object detection with template matching.
* [Deep Learning] - Object detection with deep neural network (dnn).

### Haar Cascade

 Object detection examples with haar cascade classifier algorithm (Face, eyes, mouth, other objects etc.). Cascade Classifier Training http://docs.opencv.org/3.1.0/dc/d88/tutorial_traincascade.html
 
**What is Haar cascade?**
Haar cascade classifier 
Object Detection using Haar feature-based cascade classifiers is an effective object detection method proposed by Paul Viola and Michael Jones in their paper, "Rapid Object Detection using a Boosted Cascade of Simple Features" in 2001. It is a machine learning based approach where a cascade function is trained from a lot of positive and negative images. It is then used to detect objects in other images.


### Example 1: Face And Eye Detection
**Requirements**
* OpenCV 3.x Version
* Java >6 Version


Face and eye detection by the camera using haar cascade algorithm.
Video
[![haar cascade](http://image.prntscr.com/image/f452577fac91459595baaacddb3cf924.png)](https://youtu.be/cDUNpBmymXw "Face and Eye Detection using OpenCV with Java - Real Time Camera ")



### Example 2: Object Detection and Tracking Using Color

An example of an application where OpenCV is used to detect objects based on color differences.

**Requirements**
* OpenCV  >2.x Version
* Java >6 Version


#### Example 3: Object Detection with Template Matching
Template matching is a technique for finding areas of an image that match (are similar) to a template image (patch).

**Requirements**
* OpenCV 3.x Version
* Java >6 Version


My blog post for [template matching.](http://mesutpiskin.com/blog/opencv-template-matching-ile-nesne-tespiti.html)

![Object Detecting with Template Matching](http://i.stack.imgur.com/JIoQ8.jpg)

   [Haar Cascade]: <#>
   [Color Detection]:  <#>
   [Template Matching]: <#>
   [Deep Learning]: <#>
   
#### Example 4: Object Detection with DNN

* OpenCV  > 3.3 Version

In this tutorial you will learn how to use opencv dnn module for image classification by using MobileNetSSD_deploy trained network.

My blog post for [DNN.](http://mesutpiskin.com/blog/opencv-derin-ogrenme-nesne-tanima.html)

![Object Detecting with DNN](https://i0.wp.com/mesutpiskin.com/blog/wp-content/uploads/2018/08/siniflandirma_opencv_dnn.png?zoom=2&resize=484%2C258)
