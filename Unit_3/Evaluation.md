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

