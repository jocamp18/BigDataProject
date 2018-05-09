#!/bin/bash
# $1 --> year
male_out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE YEAR='$1' AND SEX_CODE='M';"`
female_out=`hive -S -e "USE dshs; SELECT COUNT(*) FROM outpatients WHERE YEAR='$1' AND SEX_CODE='F';"`
total=$(echo "$male_out + $female_out" | bc -l)
male_per=$(echo "($male_out / $total) * 100" | bc -l)
female_per=$(echo  "($female_out / $total) * 100" | bc -l)
echo "Outpatients male proportion: " $male_per
echo "Outpatients female proportion: " $female_per
