# BigDataProject

## Descripción
Este es el primer proyecto de la materia de BigData que esta orientado a la combinación de técnicas de análitica moderna con técnicas clasicas como BI que aún es muy usado en las compañías Colombianas. Básicamente, el proyecto consta de el proceso de ETL de un conjunto de datos libres publicados por el estado de Texas sobre las emergencias presentadas en los diferentes hospitales de dicho estado, posterior a esto se debe hacer todo el procesamiento, análisis y visualización de los datos para entender la situación que allí pasa en cuanto a las consultas diarias, tanto en terminos de análitica descriptiva como predictiva.

## Prerrequisitos
* Pentaho PDI
* MySQL
* Hive
* HDFS
* HBase
* Spark

## Estructura de carpetas
```
.
├── mysql
│   ├── mysql-inpatient.txt
│   ├── mysql-outpatient.txt	
├── output
├── pdi
```

## Proceso

1. El primer trabajo que se debe hacer es realizar la extracción de todos los datos que vamos a utilizar durante la realización de este trabajo, estos pueden ser encontrados en las siguientes páginas web:

* Outpatients: http://www.dshs.texas.gov/thcic/Outpatient-Discharge-Data-Public-Use-Data-File/
* Inpatients: http://www.dshs.texas.gov/THCIC/Hospitals/Download.shtm

Este proceso de descarga puede ser realizado con un robot o manualmente.	

2. Para el proceso de transformación se utilizó la herramienta Pentaho Data Integration (PDI), con este se hicieron filtros, se eliminaron campos innecesarios y se concatenaron otros, este proceso consta de tres partes que serán explicadas a continuación:

* Mezclar la información por año: Todos los datos después de haber sido descargados quedan en formato TXT, lo que se hace en esta primer fase es organizar todos estos archivos por año, es decir, cadan archivo va a hacer referencia a todo lo que se hizo durante un año en cierta categoría (Inpatients o Outpatients). Por ejemplo, el archivo "2006-inpatients" se refiere a todo lo que pasó en el 2006 en la categoría de Inpatients.
* Transformación de Inpatients:  
