<div align="center">

**Instituto Tecnológico de Tijuana**

Departamento de Ciencias y Computación

Ingeniería en Sistemas Computacionales

 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

**Title:**
Practice 1

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
Tijuana, Baja California, April 29, 2021. 
</div>


## Practice 1

**1. Correlation**

//Import the libraries for Matrix, Vectors, Correlation and Rows
```scala
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
```

Create the val data wiht the sequence of data
```scala
val data = Seq(
  Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)
```

Create the data frame from data
```scala
val df = data.map(Tuple1.apply).toDF("features")
```

Calculate the corre;ation with the library Correlation
```scala
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
println(s"Pearson correlation matrix:\n $coeff1")
```

Calculate other but this time with Spearman
```scala
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
println(s"Spearman correlation matrix:\n $coeff2")
```

**2. Hypothesis Test**
Import libraries
```scala
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
```

Create data 
```scala
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)
```

Data to dataframe
```scala
val df = data.toDF("label", "features")
```

Calculating ChiSquare 
```scala
val chi = ChiSquareTest.test(df, "features", "label").head
//Print all variables
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")
```

**3. Summarizer**
Import libraries
```scala
import spark.implicits._    
import Summarizer._
```

Create data
```scala
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)
```

Data to Data frame
```scala
val df = data.toDF("features", "weight")
```

Use the summarize library to obtain mean and variance from the dataframe
```scala
val (meanVal, varianceVal) = df.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")
```

Repeat for new 2 variables without weight
```scala
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
  .as[(Vector, Vector)].first()
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
```
