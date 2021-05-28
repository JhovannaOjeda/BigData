<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 ![](https://www.tijuana.tecnm.mx/wp-content/themes/tecnm/images/logo_TECT.png)

**Title:**
Evaluation 

**Subject:**
BDD-1704 S DATOS MASIVOS

**Unit:**
 II

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, May 28, 2021. 
</div>

## Instructions
**Develop the following instructions in Spark with the Scala programming language, using only Spark Machine Learning Mllib library documentation and Google.**

1. Load into a dataframe Iris.csv , prepare the necessary data to be processed by the following algorithm (Important, this cleaning must be done by using a Scala script in Spark). to. Use the Spark Mllib library the corresponding Machine Learning algorithm a multilayer perceptron
2. What are the names of the columns?
3. What is the scheme like?
4. Print the first 5 columns.
5. Use the describe () method to learn more about the data in the DataFrame.
6. Make the relevant transformation for the categorical data which will be
7. our labels to be classified.
8. Build the classification model and explain its architecture.
9. Print the model results

## Development

### 1. Loading the Dataframe
##### First we import the following libraries
```scala
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer
```

##### And the Error logger (optional)
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

##### Initiate a Simple Session in Spark
```scala
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().appName("LinearRegressionAssigment").getOrCreate()

```
##### Load the data stored in LIBSVM format as a DataFrame.
```scala
val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")

```
### 2. Column Names
##### To get the name of the columns we run the following code:
```scala
data.columns.seq
```
![](https://lh3.googleusercontent.com/pw/ACtC-3d9nrTtyPPRKsoOsIAFues5cqh4M-NqbTLvczwd3TasolOHATLfBrP-O0c-66mEGUxUTE3f07BI5vMBSlJW_Jk5lj_SlrekjqCp6DwFC6y4KrO3aRx7_1h2gkFNHdvB2XbTyDIsO5R2CG6vwWdiCG-1=w1168-h56-no?authuser=1)

