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
6. Make the relevant transformation for the categorical data which will be our labels to be classified.
7. Build the classification model and explain its architecture.
8. Print theresults

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

### 3. Scheme of the Dataframe
```scala
data.printSchema()
```
![](https://lh3.googleusercontent.com/pw/ACtC-3cdvvfLlxL_KUfmm6Vg3sgjqzqkTHaiovBNdtvp5o6c8bKvRvt_qm-JzQExQGZROiaHLO6SdiNNscLUtrzBQa-BG3kQOr5Bry8_-q7PHgMqxOOVbiIVeZfIcLkzpfhTgH86SUEOAy7EWvbmrVu1fTp7=w413-h156-no?authuser=1)

### 4. First 5 rows of the Dataframe
```scala
data.show(5)
```
![](https://lh3.googleusercontent.com/pw/ACtC-3dFBzCCMfi76YQ4mLYbaXe7WDx-pziwQYRyW6v7YNcQwGNBv3Ep2tC7aDpQ64Vj7Yk44xoCQOf-hpKTacd9sxgOfTdx0DkPpqz6sBscAcJlMXcvnF6OmtrLn2-10d-WQYEqpEZI7HwHVDZRcLTiQGL-=w552-h233-no?authuser=1)

### 5. Describe function
```scala
data.describe().show()
```
![](https://lh3.googleusercontent.com/pw/ACtC-3euyBfi9jBXgDxMVDUyAhcUcjOq2QrOSV2szA-p8Yb_c9Y21_xREbZd19x9tSkzEnCpRKd1mvVGJDAUWwQT47rbvt0aFRM0ij9-TOv-8S913BpTgidmh5aMotoMSckCHZc3pq74Ol3AF5prfMebDIaa=w902-h224-no?authuser=1)

### 6. Tranformation of the categoric data (labels to classifier)
```scala
var labels = new StringIndexer().setInputCol("species").setOutputCol("label").fit(data)
labels: org.apache.spark.ml.feature.StringIndexerModel = strIdx_1c7148e3303b

 var datai = labels.transform(data)
datai: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 4 more fields]

val assembler = new VectorAssembler().setInputCols(Array("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features")
assembler: org.apache.spark.ml.feature.VectorAssembler = vecAssembler_47ba6101ca11

val dataif = assembler.transform(datai)
datif: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 5 more fields]

 dataif.show(5)
+------------+-----------+------------+-----------+-------+-----+-----------------+
|sepal_length|sepal_width|petal_length|petal_width|species|label|         features|
+------------+-----------+------------+-----------+-------+-----+-----------------+
|         5.1|        3.5|         1.4|        0.2| setosa|  2.0|[5.1,3.5,1.4,0.2]|
|         4.9|        3.0|         1.4|        0.2| setosa|  2.0|[4.9,3.0,1.4,0.2]|
|         4.7|        3.2|         1.3|        0.2| setosa|  2.0|[4.7,3.2,1.3,0.2]|
|         4.6|        3.1|         1.5|        0.2| setosa|  2.0|[4.6,3.1,1.5,0.2]|
|         5.0|        3.6|         1.4|        0.2| setosa|  2.0|[5.0,3.6,1.4,0.2]|
+------------+-----------+------------+-----------+-------+-----+-----------------+
```

### 7. Multilayer Perceptron Classifier
```scala
//Split the data in 2 parts: 1 of 70% of the original data to train the program and the other to test it
val splits = dataif.randomSplit(Array(0.7, 0.3), seed = 1234L)
splits: Array[org.apache.spark.sql.Dataset[org.apache.spark.sql.Row]] = Array([sepal_length: double, sepal_width: double ... 5 more fields], [sepal_length: double, sepal_width: double ... 5 more fields])

//First one to train
val train = splits(0)
train: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [sepal_length: double, sepal_width: double ... 5 more fields]

//Second one to test
val test = splits(1)
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [sepal_length: double, sepal_width: double ... 5 more fields]

//Layers for the Multilayer Perceptron
val layers = Array[Int](4, 5, 4, 3)
layers: Array[Int] = Array(4, 5, 4, 3)

//Put everithing together int the trainer: layers, sie of the block, seed and the max number of iterations
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
trainer: org.apache.spark.ml.classification.MultilayerPerceptronClassifier = mlpc_ae7370c5eee6

//Train the model
val model = trainer.fit(train)
21/05/30 03:30:02 WARN BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
21/05/30 03:30:02 WARN BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
21/05/30 03:30:08 ERROR StrongWolfeLineSearch: Encountered bad values in function evaluation. Decreasing step size to 0.5
21/05/30 03:30:09 ERROR StrongWolfeLineSearch: Encountered bad values in function evaluation. Decreasing step size to 0.5
21/05/30 03:30:09 ERROR StrongWolfeLineSearch: Encountered bad values in function evaluation. Decreasing step size to 0.25
21/05/30 03:30:09 ERROR StrongWolfeLineSearch: Encountered bad values in function evaluation. Decreasing step size to 0.125
model: org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel = mlpc_ae7370c5eee6
```

### 8. Print the results
'''scala
val result = model.transform(test)
result: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 8 more fields]

result.show(5)
+------------+-----------+------------+-----------+-------+-----+-----------------+--------------------+--------------------+----------+
|sepal_length|sepal_width|petal_length|petal_width|species|label|         features|       rawPrediction|         probability|prediction|
+------------+-----------+------------+-----------+-------+-----+-----------------+--------------------+--------------------+----------+
|         4.3|        3.0|         1.1|        0.1| setosa|  2.0|[4.3,3.0,1.1,0.1]|[27.0774663557616...|[1.33416057038257...|       2.0|
|         4.4|        2.9|         1.4|        0.2| setosa|  2.0|[4.4,2.9,1.4,0.2]|[27.0774663557616...|[1.33416057038257...|       2.0|
|         4.4|        3.0|         1.3|        0.2| setosa|  2.0|[4.4,3.0,1.3,0.2]|[27.0774663557616...|[1.33416057038257...|       2.0|
|         4.8|        3.1|         1.6|        0.2| setosa|  2.0|[4.8,3.1,1.6,0.2]|[27.0774663557616...|[1.33416057038257...|       2.0|
|         5.0|        3.3|         1.4|        0.2| setosa|  2.0|[5.0,3.3,1.4,0.2]|[27.0774663557616...|[1.33416057038257...|       2.0|
+------------+-----------+------------+-----------+-------+-----+-----------------+--------------------+--------------------+----------+

val predictionLabels = result.select("prediction", "label")
predictionLabels: org.apache.spark.sql.DataFrame = [prediction: double, label: double]

val evaluator = new MulticlassClassificationEvaluator().setMetricName("accur
acy")
evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = mcEval_830b33b61ec8

println(s"Test accuracy: ${evaluator.evaluate(predictionLabels)}")
Test accuracy: 0.95
```
