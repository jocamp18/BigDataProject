#!/bin/bash

for i in {1..6}
do
	echo "Output Spark " $i >> execution/output.txt
	if [ $i -eq 3 ] || [ $i -eq 6 ]
	then 
		command="spark-sql -f "$i".sql"
	else
		command="./"$i".sh 2011"
	fi
	$command >> execution/output.txt	
	echo "" >> execution/output.txt
	for j in {1..10}
	do
		{ time $command; } 2>> execution/spark-sql"$i".time
	done
	echo "Total: " >> execution/spark-sql"$i".time
	grep -E real execution/spark-sql"$i".time | sed s/[a-z]//g | awk '{ total += $1; count++ } END { print total/count}' >> execution/spark-sql"$i".time
done
