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

**6-. Apply describe() to learn about the Data Frame:
To make this, we just used describe method:
```scala
ndf.describe()
res12: org.apache.spark.sql.DataFrame = [summary: string, Open: string ... 5 more fields]
```
To obtain more explained resultas we can use the show method rigth after the instructions:
```scala
ndf.describe().show()
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
```

**7-. Creates a new Data Frame with a new column called "HV Ratio" which is the relation between price from the column "High" and the column "Volume" from the actions negotiated in one day:
```scala
val ndf2 = ndf.withColumn("HV Ratio", ndf("High")/ndf("Volume"))
ndf2: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 6 more fields]

scala> ndf2.show(3)
+-------------------+----------+------------------+----------+----------+---------+------------------+--------------------+
|               Date|      Open|              High|       Low|     Close|   Volume|         Adj Close|            HV Ratio|
+-------------------+----------+------------------+----------+----------+---------+------------------+--------------------+
|2011-10-24 00:00:00|119.100002|120.28000300000001|115.100004|118.839996|120460200|         16.977142|9.985040951285156E-7|
|2011-10-25 00:00:00| 74.899999|         79.390001| 74.249997| 77.370002|315541800|11.052857000000001|2.515989989281927E-7|
|2011-10-26 00:00:00|     78.73|         81.420001| 75.399997| 79.400002|148733900|         11.342857|5.474206014903126E-7|
+-------------------+----------+------------------+----------+----------+---------+------------------+--------------------+
only showing top 3 rows
```

**8-. Day that had the max value on the column "Close":`
Here we can look all the information that accompanies the higest value in the column "Close"
```scala
ndf.orderBy($"Close".desc).show(1)
+-------------------+-----------------+----------+----------+----------+--------+------------------+
|               Date|             Open|      High|       Low|     Close|  Volume|         Adj Close|
+-------------------+-----------------+----------+----------+----------+--------+------------------+
|2015-07-13 00:00:00|686.6900019999999|716.159996|686.550026|707.610001|33205200|101.08714300000001|
+-------------------+-----------------+----------+----------+----------+--------+------------------+
only showing top 1 row
```
But if we just want the day, we can just do 
```scala
 val ndfDes = ndf.orderBy($"Close".desc)
ndfDes: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [Date: timestamp, Open: double ... 5 more fields]

scala> ndfDes.select($"Date").show(1)
+-------------------+
|               Date|
+-------------------+
|2015-07-13 00:00:00|
+-------------------+
only showing top 1 row
```

**9-. Meaning of the column "Close":
```scala
//We are talking about stock, actions and prices, then the column "Close" has to mean the price when the stock close for a day, if it's higer that the Open the 
//it's a good news but if's not the Netflix lost.
```

**10-. Max and min from the column "Volume":
```scala
ndf.select(max("Volume")).show()
+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+


scala> ndf.select(min("Volume")).show()
+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+
```
