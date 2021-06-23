//Logistic Regression
//Import libraries
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//Import data from the csv
val data  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("C:\\Users\\Jhovanna Ojeda\\Documents\\Escuela\\BigData\\Project\\bank-full.csv")

//Create label column for the wanted prediction
var labels = new StringIndexer().setInputCol("y").setOutputCol("label").fit(data)
var datai = labels.transform(data)

//Create features column for the characteristica for the prediction
val assembler = new VectorAssembler().setInputCols(Array("age", "balance", "duration", "campaign", "pdays", "previous")).setOutputCol("features")
val datait = assembler.transform(datai)

//Split the original date on a train set and a test set
val Array(trainData, testData) = datait.randomSplit(Array(0.7, 0.3), seed = 1234L)

//Create the array for the accuracy and errors result for the loop
var a = new Array[Double](30)
var e = new Array[Double](30)
//Loop for 30 
for(i <- Range(0, 30)){
	//Aplicate the algoritm
	//Initial LogisticRegression
	val lr = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8)

	//Fit it on the train set (model)
	val lrModel = lr.fit(trainData)

	//Make the predictions tranforming the test set with the model 
	val predictions = lrModel.transform(testData)

	//Evaluate it
	val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
	val accuracy = evaluator.evaluate(predictions)

	//Keep the accuracy and error data
	a(i) = accuracy
	e(i) = 1 - accuracy
}

//Print it
a
e