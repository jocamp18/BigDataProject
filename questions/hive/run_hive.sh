#!/bin/bash

for i in {1..6}
do
	echo "Output Hive " $i >> execution/output.txt
	if [ $i -eq 3 ] || [ $i -eq 6 ]
	then 
		command="hive -f "$i".hql"
	else
		command="./"$i".sh 2011"
	fi
	$command >> execution/output.txt	
	echo "" >> execution/output.txt
	for j in {1..10}
	do
		{ time $command; } 2>> execution/hive"$i".time
	done
	echo "Total: " >> execution/hive"$i".time
	grep -E real execution/hive"$i".time | sed s/[a-z]//g | awk '{ total += $1; count++ } END { print total/count}' >> execution/hive"$i".time
done
