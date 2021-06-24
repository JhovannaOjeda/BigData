<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 ![](https://www.tijuana.tecnm.mx/wp-content/themes/tecnm/images/logo_TECT.png)

**Title:**
Final Project 

**Subject:**
BDD-1704 S DATOS MASIVOS

**Unit:**
 4

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, June 23, 2021. 
</div>


## Introduction
In this paper we will present a performance comparison between different machine learning algorithms to check which one is faster and more accurate at the time of predicting results; for this we will use the same data set for all of them. The machine learning algorithms to be applied are: SVM, Decision Tree, Logistic Regression and Multilayer Perceptron, which have already been explored in previous classes.

## Theoretical framework

#### Machine learning
Machine learning is a branch of artificial intelligence (AI) focused on creating applications that learn from data and improve their accuracy over time without being programmed to do so. In data science, an algorithm is a sequence of statistical processing steps. In machine learning, algorithms are "trained" to find patterns and features in massive amounts of data in order to make decisions and predictions based on new data. The better the algorithm, the more accurate the decisions and predictions will be as it processes more data. 

#### SVM
Support vector machine (SVM) is a supervised learning algorithm used in many classification and regression problems, including medical applications in signal processing, natural language processing, and image and speech recognition. The goal of the SVM algorithm is to find a hyperplane that best separates two different classes of data points. "Best possible way" implies the hyperplane with the widest margin between the two classes, represented by the plus and minus signs in the figure below. The algorithm can only find this hyperplane in problems that allow linear separation.

#### Decision Tree
A decision tree classifies data items by asking a series of questions about the features associated with the items. Each question is contained in a node and each internal node points to a child node for each possible answer to its question. The questions thus form a hierarchy, coded as a tree. In the simplest form, we ask yes or no questions, and each internal node has a "yes" child and a "no" child. An element is classified into a class by following the path from the top node, the root, to a childless node, a leaf, based on the answers that apply to the element under consideration. An element is assigned to the class that has been associated with the arriving leaf. 

#### Logistic Regression

#### Multilayer Perceptron


## Implementation

#### Spark With Scala
Apache Spark is a distributed data processing programming framework designed to be fast and general purpose. As its name suggests, it has been developed under the Apache project, which guarantees its open source license. 

Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant and type-safe manner. It easily integrates features of functional and object-oriented languages.

Spark was chosen to work with because it is a working environment compatible with scala, an optimal language for data manipulation and application of machine learning algorithms. Apache Spark is an open source unified analytics engine for large-scale data processing while scala is a strong general purpose programming language with static types that supports both object-oriented and functional programming. Designed to be concise, many of Scala's design decisions are aimed at addressing criticisms of Java.


## Results

### SVM
In this SVM method, the first run takes the longest time since it loads all the libraries and code for the first time, its time was 14 seconds while the average of the 30 runs was 10 seconds and the accuracy was 88 % and the error was 11.69 %.

![image](https://user-images.githubusercontent.com/60414135/123190165-e720e980-d453-11eb-8d12-b898577a93b6.png)

#### Average
![image](https://user-images.githubusercontent.com/60414135/123190283-1e8f9600-d454-11eb-8b1a-1b2b3c51e6d4.png)

### Decision Tree
In this Decision Tree method, the first run takes more time, its time was 14 seconds while the average of the 30 runs was 10.6 seconds and the accuracy was 88.21 % and the error of 11.76 % was very similar to the SVM method, the difference is that it had a delay in the attempt #22 of 36 seconds delay.

![image](https://user-images.githubusercontent.com/60414135/123190350-3ff08200-d454-11eb-9f70-ddcdf4ff3156.png)

#### Average
![image](https://user-images.githubusercontent.com/60414135/123190380-4b43ad80-d454-11eb-9fc4-84da5d968789.png)



