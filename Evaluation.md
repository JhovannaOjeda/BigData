<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://www.tijuana.tecnm.mx/wp-content/themes/tecnm/images/logo_TECT.png)]

**Title:**
Evaluation 

**Subject:**
BDD-1704 S DATOS MASIVOS

**Unit:**
 I

**Professor:**
JOSE CHRISTIAN ROMERO HERNANDEZ

**Student:**

Jhovanna Andrea Ojeda Sanchez
15211334

Garcia Rincon Daniel Gerardo
16212002



**Date:**
Tijuana, Baja California, April 15, 2020. 
</div>


**1-. Start a simple session in spark**

Import the following library to start the spark session
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
```
Declare the variable spark to initialize the session, this will allow us to work with data frames using sql.

```scala
val spark = SparkSession.builder().getOrCreate()
```
**2-. Upload Netflix Stock CSV file, make Spark infer data types.**

To load the csv we use the following method, indicating that there is a header and providing the path of the file.
```scala
//Load the csv
val ndf = spark.read.option("header", "true").option("inferSchema","true")csv("C:\\Users\\Daniel Garcia\\Desktop\\Evaluacion_1 1_Scala\\Netflix_2011_2016.csv")
```
**3-. What are the column names?**

To get the names of the columns of a csv, we used the columns method, this will throw an array that contains all the headers of the data frame.
```scala
//Name of the columns
ndf.columns
res4: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
```

**4-. How is the scheme?**

To print the data frame schema, we used the printSchema() method. This method will throw a list that shows the type of data that contains the csv.
```scala
ndf.printSchema()


root
 |-- Date: string (nullable = true)
 |-- Open: string (nullable = true)
 |-- High: string (nullable = true)
 |-- Low: string (nullable = true)
 |-- Close: string (nullable = true)
 |-- Volume: string (nullable = true)
 |-- Adj Close: string (nullable = true)
```

**5-. Print the first 5 columns.**

To print the first five columns, we used the select method, writing the name of the first five columns and showing just one record of the csv.
```scala
scala> ndf.select("Date", "Open", "High", "Low", "Close").show(1)
```


|               Date|      Open|              High|       Low|     Close|
|-------------------|----------|------------------|----------|----------|
|2011-10-24 00:00:00|119.100002|120.28000300000001|115.100004|118.839996|

only showing top 1 row
