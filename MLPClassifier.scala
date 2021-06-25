//MLPClassifier
//Import libraries
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
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
val splits = datait.randomSplit(Array(0.6, 0.4), seed = 1234L)
val trainData = splits(0)
val testData= splits(1)

//Create the array for the accuracy and errors result for the loop
var a = new Array[Double](30)
var e = new Array[Double](30)
//Loop for 30 
for(i <- Range(0, 30)){
	//Aplicate the algoritm
	//Stablish the layers (6 characteristics, 2 result categories)
	val layers = Array[Int](6, 5, 4, 2)

	//Trainer from the MultilayerPerceptronClassifier librarie
	val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(10)

	//Model
	val mpcModel = trainer.fit(trainData)

	//Results
	val predictions = mpcModel.transform(testData)
	val predictionAndLabels = predictions.select("prediction", "label")
	val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
	val accuracy = evaluator.evaluate(predictionAndLabels)

	//Keep results
	a(i) = accuracy
	e(i) = 1 - accuracy
}
//Print
a
e