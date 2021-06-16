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
 3

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, June 15, 2021. 
</div>


## Instructions
Develop the following instructions in Spark with the Scala programming language.

Objective:
The goal of this hands-on test is to try to group customers from specific regions of a wholesaler. This based on the sales of some product categories.

1. Import a simple Spark session.
2. Use lines of code to minimize errors
3. Create an instance of the Spark session
4. Import the K-library means for the clustering algorithm.
5. Load the wholesale customer data dataset
6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call it set feature_data
7. Import Vector Assembler and Vector
8. Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
9. Use the assembler object to transform feature_data
10. Create a Kmeans model with K = 3
11. Evaluate the groups using within the WSSSE Sum of Squared Errors set and print the centroids.


## Development

1. Import a simple Spark session.

```scala
import org.apache.spark.sql.SparkSession
```

2. Use lines of code to minimize errors

```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

3. Create an instance of the Spark session

```scala
val spark = SparkSession.builder().appName("LinearRegressionAssigment").getOrCreate()
```

4. Import the K-means library for the cluster algorithm.

```scala
import org.apache.spark.ml.clustering.KMeans
```

5. Load the wholesale customer dataset

```scala
val data = spark.read.option("header", "true").option("inferSchema","true")csv("C:\\Users\\Donny\\Documents\\BigData\\Spark_clustering\\Wholesale_customers_data.csv")

```

6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data

```scala
val  fd  = data.select("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")
fd.show(5)
```
![image](https://user-images.githubusercontent.com/60414135/121989718-7130ca00-cd51-11eb-8d29-3f73700f8d8d.png)

7. Import Vector Assembler

```scala
import org.apache.spark.ml.feature.VectorAssembler
```

8. Create a new Assembler Object from the features

```scala
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")
```

9. Transform the features_data

```scala
val features_datat = assembler.transform(features_data)
```

10. Create the model K-Means with K=3

```scala
val km = new KMeans().setK(3).setSeed(123L)
val m = km.fit(features_datat)
```

11. Evalute the groups with Set Sum from WSSSE and print the centroids

```scala
val pre = m.transform(features_datat)
val evaluator = new ClusteringEvaluator()
val evaluation = evaluator.evaluate(pre)
evaluation: Double = 0.6482181662567144
println(s"Evaluation = $evaluation")
Evaluation = 0.6482181662567144
println("Cluster Centers: ")
m.clusterCenters.foreach(println)
[32768.013333333336,4827.68,5723.146666666667,5535.92,1074.1200000000001,2066.6400000000003]
[7390.958456973294,4439.768545994066,6292.19584569733,2495.53412462908,2238.6528189910982,1158.4480712166173]
[11849.17857142857,24717.10714285714,33887.71428571428,3409.3214285714284,15459.714285714284,4483.857142857142]
```

