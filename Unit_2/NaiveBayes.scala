import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession

// Cargar datos en formato de almacenamiento LIBSVM como un DataFrame.
val data = spark.read.format("libsvm").load("C:/Users/brise/Documents/GitHub/NaiveBayes/sample_libsvm_data.txt")

println ("Numero de lineas en el archivo de datos:" + data.count ())

// Mostrar 20 l�neas por defecto
data.show()

// Divida aleatoriamente el conjunto de datos en conjunto de entrenamiento y conjunto de prueba de acuerdo con los pesos proporcionados. Tambi�n puede especificar una semilla
val Array (trainingData, testData) = data.randomSplit (Array (0.7, 0.3), 100L) // El resultado es el tipo de matriz, y la matriz almacena los datos del tipo DataSet

// Incorporar al conjunto de entrenamiento (operaci�n de ajuste) para entrenar un modelo bayesiano
val naiveBayesModel = new NaiveBayes().fit(trainingData)

// El modelo llama a transform () para hacer predicciones y generar un nuevo DataFrame
val predictions = naiveBayesModel.transform(testData)

// Salida de datos de resultados de predicci�n
predictions.show()
 
//Evaluaci�n de precisi�n del modelo
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

val precision = evaluator.evaluate (predictions) // Precisi�n

println ("tasa de error =" + (1-precision))